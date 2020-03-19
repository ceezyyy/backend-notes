package Demo1;


public class MyInterfaceImpl implements MyInterfaceAbs {
    // 实现类必须 override 接口类所有的方法
    @Override
    public void methodAbs() {
        System.out.println("Testing");
    }

}


