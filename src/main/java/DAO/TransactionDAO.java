/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TransactionDTO;
import Generic.DBManager;
import Generic.Pair;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cafer
 */
public class TransactionDAO implements DAOInterface<TransactionDTO> {

    private final Logger logger = LogManager.getLogger(RegisteredSessionDAO.class.getName());
    private ArrayList<DTO.TransactionDTO> transactions;

    public TransactionDAO() {
        transactions = new ArrayList<>();
    }

    @Override
    public ArrayList<TransactionDTO> getAll() {
        DBManager db = new DBManager();
        String query = "SELECT * FROM Transactions;";
        Pair<Connection, ResultSet> queryResult;
        Connection dbconn;
        ResultSet sessionResult;
        try {
            queryResult = db.resultQuery(query);
            dbconn = queryResult.getLeft();
            sessionResult = queryResult.getRight();
        } catch (SQLException e) {
            logger.error("Unable to query transactions from DB", e);
            return transactions;
        }

        try {
            while (sessionResult.next()) {
                RegisteredSessionDAO rs = new RegisteredSessionDAO();
                UserDAO us = new UserDAO();

                TransactionDTO sess = new TransactionDTO(
                        sessionResult.getString("transaction_id"),
                        rs.findBySessionId(sessionResult.getString("session_id")),
                        sessionResult.getDouble("discount"),
                        sessionResult.getDouble("final_price"),
                        us.findUserById(sessionResult.getString("member_id")),
                        sessionResult.getString("member_level_atm"),
                        us.findUserById(sessionResult.getString("staff_id")),
                        sessionResult.getInt("status"),
                        sessionResult.getInt("date_created"),
                        sessionResult.getInt("date_modified")
                );
                transactions.add(sess);
            }
        } catch (SQLException e) {
            logger.error("Unable to read ResultSet of registered session query", e);
        }

        return transactions;
    }

    @Override
    public void save(TransactionDTO t) throws SQLException {
        DBManager db = new DBManager();
        Object[] args = new Object[]{
            t.getTransactionId(),
            t.getSessionId(),
            t.getDiscount(),
            t.getFinalPrice(),
            t.getMemberId(),
            t.getMemberLevelAtm(),
            t.getStaffId(),
            t.getStatus(),
            t.getDateCreated(),
            t.getDateModified()
        };
        String query = String.format("INSERT INTO Transactions VALUES("
                + "'%s',"
                + "'%s',"
                + "'%f',"
                + "'%f',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "%d,"
                + "strftime('%%s', 'now'),"
                + "strftime('%%s', 'now')"
                + ");", args);
        db.execQuery(query);
        logger.info("Successfully added record in DB (transaction_id: " + t.getTransactionId() + ")");

        this.transactions.add(t);
    }

    @Override
    public void update(TransactionDTO t, HashMap<String, Object> params) throws SQLException {
        DBManager db = new DBManager();
        String setClause = "SET ";
        String whereClause = String.format(" WHERE transaction_id='%s'", t.getTransactionId());

        boolean useSetClause = false;
        if (params.containsKey("session_id")) {
            setClause += String.format("session_id = '%s',", params.get("session_id"));
            useSetClause = true;
        }
        if (params.containsKey("discount")) {
            setClause += String.format("discount = '%f',", params.get("discount"));
            useSetClause = true;
        }
        if (params.containsKey("final_price")) {
            setClause += String.format("final_price = '%f',", params.get("final_price"));
            useSetClause = true;
        }
        if (params.containsKey("member_id")) {
            setClause += String.format("member_id = '%s',", params.get("member_id"));
            useSetClause = true;
        }
        if (params.containsKey("status")) {
            setClause += String.format("status = %d,", params.get("status"));
            useSetClause = true;
        }
        if (params.containsKey("date_created")) {
            setClause += String.format("date_created = '%s',", params.get("date_created"));
            useSetClause = true;
        }
        if (params.containsKey("date_modified")) {
            setClause += String.format("date_modified = '%s',", params.get("date_modified"));
            useSetClause = true;
        }

        // Remove last character from setClause to remove additional ',' from string
        setClause = setClause.substring(0, setClause.length() - 1);

        String query = "UPDATE Transactions " + (useSetClause ? setClause : "") + whereClause;
        logger.info("Executing query: " + query);
        db.execQuery(query);
        logger.info("Successfully updated record in DB (transaction_id: " + t.getTransactionId() + ")");
    }

    @Override
    public void delete(TransactionDTO t) throws SQLException {
        DBManager db = new DBManager();
        this.transactions.remove(t);
        String query = String.format("DELETE FROM Transactions WHERE transaction_id='%s'", new Object[]{t.getTransactionId()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (transaction_id: " + t.getTransactionId() + ")");
    }

    public TransactionDTO findByTransactionid(String transaction_id) {
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getTransactionId().equals(transaction_id)) {
                return this.transactions.get(i);
            }
        }
        return null;
    }
    
    public String getNewTransactionId() {
        DBManager db = new DBManager();
        String sql = "SELECT max(transaction_id) as transaction_id FROM Transactions";
        String maxTransId = "T0001";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();

            rs.next();
            String res = rs.getString("transaction_id");
            conn.close();
            if (res == null) {
                return maxTransId;
            }

            maxTransId = res;

        } catch (SQLException e) {
            logger.error("Fail to get max transaction id", e);
        }

        // U014
        // "014"
        int num = Integer.parseInt(maxTransId.substring(1, maxTransId.length())) + 1;
        maxTransId = String.format("T%04d", new Object[]{num});
        return maxTransId;
    }
}
