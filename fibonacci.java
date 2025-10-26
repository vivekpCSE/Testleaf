public class fibonacci {
public static void main(String[] args){
    int r = 8;
int a=0,b=1;
for(int i=0;i<=r;i++){
    System.out.println(a+"");
    int next = a+b;
    a=b;
    b=next;
}
}
}