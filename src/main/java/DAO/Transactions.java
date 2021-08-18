/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Transaction;
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
public class Transactions implements DAOInterface<Transaction> {

    private final Logger logger = LogManager.getLogger(RegisteredSessions.class.getName());
    private ArrayList<DTO.Transaction> transactions;

    public Transactions() {
        transactions = new ArrayList<>();
    }

    @Override
    public ArrayList<Transaction> getAll() {
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
                RegisteredSessions rs = new RegisteredSessions();
                Users us = new Users();

                Transaction sess = new Transaction(
                        sessionResult.getString("transaction_id"),
                        rs.findBySessionId("session.id"),
                        sessionResult.getDouble("discount"),
                        sessionResult.getDouble("final_price"),
                        us.findUserById("member_id"),
                        sessionResult.getString("member_level_atm"),
                        us.findUserById("staff_id"),
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
    public void save(Transaction t) throws SQLException {
        DBManager db = new DBManager();
        Object[] args = new Object[]{
            t.getTransactionId(),
            t.getSessionId(),
            t.getDiscount(),
            t.getFinalPrice(),
            t.getMemberId(),
            t.getMemberLevelAtm(),
            t.getStaffId(),
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
                + "strftime('%%s', 'now'),"
                + "strftime('%%s', 'now')"
                + ");", args);
        db.execQuery(query);
        logger.info("Successfully added record in DB (transaction_id: " + t.getTransactionId() + ")");

        this.transactions.add(t);
    }

    @Override
    public void update(Transaction t, HashMap<String, Object> params) throws SQLException {
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
            setClause += String.format("final_price = %f,", params.get("final_price"));
            useSetClause = true;
        }
        if (params.containsKey("member_id")) {
            setClause += String.format("member_id = '%s',", params.get("member_id"));
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
    public void delete(Transaction t) throws SQLException {
        DBManager db = new DBManager();
        this.transactions.remove(t);
        String query = String.format("DELETE FROM Transactions WHERE transaction_id='%s'", new Object[]{t.getTransactionId()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (transaction_id: " + t.getTransactionId() + ")");
    }

    public Transaction findByTransactionid(String transaction_id) {
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getTransactionId().equals(transaction_id)) {
                return this.transactions.get(i);
            }
        }
        return null;
    }
    
    public String getNewTransactionID() {
        DBManager db = new DBManager();
        String sql = "SELECT max(transaction_id) as transaction_id FROM Transactions";
        String maxTransId = "T0001";
        boolean dataExists = false;
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();

            while (rs.next()) {
                dataExists = true;
                maxTransId = rs.getString("transaction_id");
                break;
            }

        } catch (SQLException e) {
            logger.error("Fail to get max transaction id", e);
        }
        if (!dataExists) {
            return maxTransId;
        }
        
        int num = Integer.parseInt(maxTransId.substring(1, maxTransId.length())) + 1;
        maxTransId = String.format("T%04d", new Object[]{num});
        return maxTransId;
    }
}
