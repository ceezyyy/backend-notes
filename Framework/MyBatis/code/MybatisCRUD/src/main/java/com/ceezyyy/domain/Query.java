package com.ceezyyy.domain;

import java.util.List;

public class Query {
    /**
     * Description: Query Object
     *
     * @param:
     * @return:
     */
    private User user;
    private List<Integer> ids;

    public Query() {
    }

    public Query(User user, List<Integer> ids) {
        this.user = user;
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Query{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}
