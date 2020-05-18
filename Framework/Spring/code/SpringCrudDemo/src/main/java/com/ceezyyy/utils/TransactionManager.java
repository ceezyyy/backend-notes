package com.ceezyyy.utils;

import java.sql.SQLException;

public class TransactionManager {
    private ConnectionUtil connectionUtil;

    // spring dependency injection
    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    public void beginTransaction() {
        /**
         * Description: begin transaction
         * @param: []
         * @return: void
         */
        try {
            // manual
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commitTransaction() {
        /**
         * Description: commit transaction
         * @param: []
         * @return: void
         */
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollbackTransaction() {
        /**
         * Description: rollback transaction
         * @param: []
         * @return: void
         */
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void releaseTransaction() {
        /**
         * Description: release transaction and unbind connection
         * @param: []
         * @return: void
         */
        try {
            // release
            connectionUtil.getThreadConnection().close();
            // unbind
            connectionUtil.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
