
public class Easter {
	
	
public String getMonthAndDate(String year) {
		
		int y = Integer.parseInt(year);
		int a,b,c,d,e,f,g,h,i,k,r,m,n,p;
		
		a=y%19;
		b=y/100;
		c=y%100;
		d=b/4;
		e=b%4;
		f=(b+8)/25;
		g =(b-f+1)/3;
		h=(19 * a + b - d - g + 15)%30;
		i=c/4;
		k=c%4;
		r=(32 + 2 * e + 2 * i - h - k)%7;
		m=(a + 11 * h + 22 * r)/451;
		n=(h + r - 7 * m + 114)/31;
		p=(h + r - 7 * m + 114)%31 +1;
		
		return n+"/"+p+"/"+year; 
	}
}
