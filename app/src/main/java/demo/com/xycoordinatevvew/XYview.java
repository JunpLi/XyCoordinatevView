package demo.com.xycoordinatevvew;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;


/**
 * Created by ljp on 2017/3/15
 */
public class XYview extends View {

   
    /**
     * 控件的中心点
     */
	
    int centerX, centerY;

    /**
     * 圆心（坐标值是相对与控件的左上角的）
     */
    Point po = new Point();

    public XYview(Context context) {
        super(context, null);
    }

    public XYview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

  
    /**
     * 控件创建完成之后，在显示之前都会调用这个方法，此时可以获取控件的大小 并得到中心坐标和坐标轴圆心所在的点。
     */
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w/2;
        centerY = h/2;
        po.set(centerX, centerY);//中心点
        super.onSizeChanged(w, h, oldw, oldh);
    }

    
   
   
    
    /**
     * 自定义控件一般都会重载onDraw(Canvas canvas)方法，来绘制自己想要的图形
     */
    @Override
    public void onDraw(Canvas canvas) {
    	
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth((float) 2.0); 
        paint.setTextSize(18);
        paint.setColor(Color.parseColor("#303030"));
        paint.setAntiAlias(true);

             // 画坐标轴
        if (canvas != null) {
         
            // 画直线
            canvas.drawLine(5, 2*centerY-40, 2 * centerX, 2*centerY-40, paint);//x轴
            canvas.drawLine(5, 10, 5, 2*centerY-40, paint);//y轴
            // 画X轴箭头
            int x = 2 * centerX, y = 2*centerY-40;//减去40是为了避免画在最底部，看不到，所以减去40
            drawTriangle(canvas, new Point(x, y), new Point(x - 10, y - 5),
                    new Point(x - 10, y + 5));//三点决定一个三角形，并且填充
            canvas.drawText("90", x - 20, y +18, paint);
            // 画Y轴箭头
            x = 5;  y = 0;
            drawTriangle(canvas, new Point(x, y), new Point(x - 5, y + 10),
                    new Point(x + 5, y + 10));
            canvas.drawText("300", x + 12, y + 15, paint);
            // 画中心点坐标
            // 先计算出来当前中心点坐标的值
            String centerString = "(" + (centerX - po.x) / 2 + ","
                    + (po.y - centerY) / 2 + ")";
        
            // 然后显示坐标
            canvas.drawText(centerString, 2, 2*centerY - 15, paint);
        }
        
      

        if (canvas != null) {
          
        	Point p_1 = new Point(10,20);
    		Point p_2 = new Point(20,170);
    		Point p_3 = new Point(30,40);
            	
    		int size=2*centerX-15;
    		float n=size/40;
        	canvas.drawLine(5+n*p_1.x,2*po.y-40-p_1.y,5+n*p_2.x,2*po.y-40-p_2.y, paint);//画出点 1和 点2 两点之间的连线
        	
        	canvas.drawLine(5+n*p_2.x,2*po.y-40-p_2.y,5+n*p_3.x,2*po.y-40-p_3.y, paint);//画出点 2和 点3 两点之间的连线
        	
        	/**
        	 * 
        	 * 
        	 * 上面是3个点连接，为了方便我只设置了3个点的连接，加入你有有很多点要连接的时候，可以有循环，canvas.drawLine不就是前面一个连接后面的一个很简单
        	 * 
        	 * 
        	 * */
        	
        	
    		
            	   //显示该黑点
            	   canvas.drawCircle(5+n*p_1.x, 2*po.y-40-p_1.y, 2, paint);
                   canvas.drawCircle(5+n*p_2.x, 2*po.y-40-p_2.y, 2, paint);
                   canvas.drawCircle(5+n*p_3.x, 2*po.y-40-p_3.y, 2, paint);
        	
        	
           // canvas.drawPoint(pa.x+po.x, po.y-pa.y, paint);
        }

    }

    /**
     * 画三角形 用于画坐标轴的箭头
     */
    private void drawTriangle(Canvas canvas, Point p1, Point p2, Point p3) {
        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        path.close();

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        // 绘制这个多边形
        canvas.drawPath(path, paint);
    }
    
}