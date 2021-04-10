/**
 * <p>
 * 消息类
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/7
 */
public class Msg {

    private int id;
    private Object val;

    public Msg(int id, Object val) {
        this.id = id;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public Object getVal() {
        return val;
    }

}
