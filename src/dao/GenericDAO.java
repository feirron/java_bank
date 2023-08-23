package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.exceptions.DAOException;

public abstract class GenericDAO {
    protected Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public void close() {
        try {
            this.connection.close();
        }
        catch (SQLException e) {
            throw new DAOException("Fail to close connection",e);
        }
    }

    public void spitOutAllTableRows(String tableName) {
        try {
            System.out.println("current " + tableName + " is:");
            try (PreparedStatement selectStmt = this.connection.prepareStatement(
                    "SELECT * from " + tableName, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                 ResultSet rs = selectStmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("no rows found");
                }
                else {
                    System.out.println("types:");
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        System.out.print(rs.getMetaData().getColumnName(i + 1) + ":" + rs.getMetaData().getColumnTypeName(i + 1) + " ");
                    }
                    System.out.println();
                    while (rs.next()) {
                        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
                            System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
                        }
                        System.out.println();
                    }
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
