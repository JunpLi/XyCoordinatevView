package demo.com.xycoordinatevvew;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import demo.com.xycoordinatevvew.bean.XyBean;
import demo.com.xycoordinatevvew.view.XyView;

/**
 * Created by ljp on 2017/3/15
 */
public class MainActivity extends Activity {

    private XyView xyView;
    private List<XyBean> xyBeanList = new ArrayList<XyBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xyView = findViewById(R.id.xy_view);
        drawXyLine();
        xyView.setBeanListToXYview(xyBeanList);

    }


    private void drawXyLine(){
        XyBean xyBean0 = new XyBean();
        xyBean0.setX(0);
        xyBean0.setY(10);

        XyBean xyBean1 = new XyBean();
        xyBean1.setX(10);
        xyBean1.setY(20);

        XyBean xyBean2 = new XyBean();
        xyBean2.setX(20);
        xyBean2.setY(70);

        XyBean xyBean3 = new XyBean();
        xyBean3.setX(30);
        xyBean3.setY(150);

        XyBean xyBean4 = new XyBean();
        xyBean4.setX(40);
        xyBean4.setY(99);

        XyBean xyBean5 = new XyBean();
        xyBean5.setX(50);
        xyBean5.setY(76);

        xyBeanList.add(xyBean0);
        xyBeanList.add(xyBean1);
        xyBeanList.add(xyBean2);
        xyBeanList.add(xyBean3);
        xyBeanList.add(xyBean4);
        xyBeanList.add(xyBean5);

       }


}



