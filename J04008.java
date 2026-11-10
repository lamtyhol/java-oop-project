import java.util.*;
    class point{
        double x,y;
       public point(){};

       public point(double x, double y){
            this.x=x; 
            this.y=y;

        }
    
        public point( point p){
            this.x=p.x;
            this.y=p.y;
        }
        public double gx(){
            return x;
        }
        public double gy(){
            return y;
        }
        public static double kc(point p1, point p2){
            return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
        }

        public double kc(point p){
             return Math.sqrt(Math.pow(this.x-p.x,2)+Math.pow(this.y-p.y,2));
        }
        @Override 
        public String toString(){
            return x + " " + y;
        }
    }

    class tamgiac{
        point p1,p2,p3;
        double a,b,c;
        public tamgiac(point p1, point p2, point p3){
            this.p1=p1;
            this.p2=p2;
            this.p3=p3;

            this.a= this.p2.kc(this.p3);
            this.b=this.p1.kc(this.p3);
            this.c=this.p2.kc(this.p1);
        }
        public boolean valid() {
            return (a + b > c) && (a + c > b) && (b + c > a);
                        }    

        public double gcv() {
              return (Math.sqrt((a+b+c)*(a+b-c)*(b+c-a)*(c+a-b)))/4;

                 }

        
        }

    

public class J04008 {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int t= sc.nextInt();
    while(t-->0){
        point p1= new point(sc.nextDouble(),sc.nextDouble());
        point p2= new point(sc.nextDouble(),sc.nextDouble());
        point p3= new point(sc.nextDouble(),sc.nextDouble());
        tamgiac tg= new tamgiac(p1,p2,p3);
        if(!tg.valid()){
            System.out.println("INVALID");
        } else {
            System.out.printf("%.2f\n",tg.gcv());
        }
    }

  }

}

