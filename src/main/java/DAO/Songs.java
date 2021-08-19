package DAO;

import DTO.Song;
import Generic.DBManager;
import Generic.Pair;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Chin Sze Sing
 */
public class Songs implements DAOInterface<Song> {

    private DBManager db;
    private final Logger logger = LogManager.getLogger(Songs.class.getName());
    private ArrayList<DTO.Song> songArray;
    
    public Songs() {
        songArray = new ArrayList<>();
    }

    @Override
    public ArrayList<Song> getAll() {
        db = new DBManager();
        String sql = "SELECT * FROM songs";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet resultSet = result.getRight();

            while (resultSet.next()) {
                Song songData = new Song(
                        resultSet.getString("song_id"),
                        resultSet.getString("name"),
                        resultSet.getString("artist"),
                        resultSet.getString("album"),
                        resultSet.getString("genre"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("date_created"),
                        resultSet.getInt("date_modified")
                );
                songArray.add(songData);
            }
            conn.close();
        } catch (SQLException e) {
            logger.error("Failed to get all song data");
        }
        return songArray;
    }

    @Override
    public void save(Song t) throws SQLException {
        db = new DBManager();
        String sql = String.format(
                "INSERT INTO songs VALUES('%s', '%s', '%s', '%s', '%s', '%d', '%d', '%d')",
                new Object[]{
                    t.getSongId(),
                    t.getName(),
                    t.getArtist(),
                    t.getAlbum(),
                    t.getGenre(),
                    t.getDuration(),
                    t.getDateCreated(),
                    t.getDateModified()
                });
        db.execQuery(sql);
    }

    public Song findSongById(String song_id) {
        db = new DBManager();
        String sql = String.format("SELECT * FROM songs WHERE song_id = '%s'", new Object[]{song_id});
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();
            boolean found = false;
            while (rs.next()) {
                found = true;
                Song songData = new Song(
                        rs.getString("song_id"),
                        rs.getString("name"),
                        rs.getString("artist"),
                        rs.getString("album"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getInt("date_created"),
                        rs.getInt("date_modified")
                );
                conn.close();
                return songData;
            }
            conn.close();
            return null;
        } catch (SQLException e) {
            logger.error("SQLError: Failed to find song by id");
        }
        return null;
    }

    @Override
    public void update(Song t, HashMap params) throws SQLException {
        db = new DBManager();
        String setClause = "SET ";
        String whereClause = String.format(" WHERE song_id='%s'", t.getSongId());

        boolean useSetClause = false;
        if (params.containsKey("name")) {
            setClause += String.format("name = '%s',", params.get("name"));
            useSetClause = true;
        }
        if (params.containsKey("artist")) {
            setClause += String.format("artist = '%s',", params.get("artist"));
            useSetClause = true;
        }
        if (params.containsKey("album")) {
            setClause += String.format("album = '%s',", params.get("album"));
            useSetClause = true;
        }
        if (params.containsKey("genre")) {
            setClause += String.format("genre = '%s',", params.get("genre"));
            useSetClause = true;
        }
        if (params.containsKey("duration")) {
            setClause += String.format("duration = %d,", params.get("duration"));
            useSetClause = true;
        }

        // Remove last character from setClause to remove additional ',' from string
        setClause = setClause.substring(0, setClause.length() - 1);

        String query = "UPDATE Songs " + (useSetClause ? setClause : "") + whereClause;
        logger.info("Executing query: " + query);
        db.execQuery(query);
        logger.info("Successfully updated record in DB (song_id: " + t.getSongId() + ")");
    }

    @Override
    public void delete(Song t) throws SQLException {
        db = new DBManager();
        DBManager db = new DBManager();
        this.songArray.remove(t);
        String query = String.format("DELETE FROM Songs WHERE song_id='%s'", new Object[]{t.getSongId()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (song_id: " + t.getSongId() + ")");
    }

    public String getNewSongID() {
        db = new DBManager();
        String sql = "SELECT max(song_id) as song_id FROM Songs";
        String maxSongId = "S001";
        boolean dataExists = false;
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();

            rs.next();
            String res = rs.getString("song_id");
            conn.close();
            if (res == null) {
                return maxSongId;
            }

            maxSongId = res;
            dataExists = true;
        } catch (SQLException e) {
            logger.error("Fail to get max song id", e);
        }
        if (!dataExists) {
            return maxSongId;
        }

        int num = Integer.parseInt(maxSongId.substring(1, maxSongId.length())) + 1;
        maxSongId = String.format("S%03d", new Object[]{num});
        return maxSongId;
    }

}
