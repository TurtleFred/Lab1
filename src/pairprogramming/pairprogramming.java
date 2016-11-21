package pairprogramming;
import java.util.*;
import java.lang.*;
import java.math.*;

public class pairprogramming {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner temp=new Scanner(System.in);
		String test=temp.next();
		String test1=test;
		String test2=new String();
		System.out.println(test+"\n");
		for (int i=0; ;i++){
			System.out.print("!simplify ");
			Scanner valuetemp=new Scanner(System.in);
			String  value=valuetemp.next();
			Stack S1 =new Stack(),S2 =new Stack();
			String array[]=new String[test.length()];
			array=expression(test);
			test=simplify(array,test,value);
			test2=test;
			System.out.print("!d/d");
			Scanner xtemp=new Scanner(System.in);
			char x=xtemp.nextLine().charAt(0);
			if (i==0){
				derivative(test1,x);
			}
			else
				derivative(test2,x);
		}
	}


	  private static String[] expression(String test)//ǰ׺���ʽת��Ϊ��׺
	 {	
		    char testArray[] =test.toCharArray();
		    String arraytemp[]=new String[testArray.length];
		 	int starter=0,ender=0;
			Stack S1 =new Stack(),S2 =new Stack();
			S1.empty();
			S2.empty();//����ջ������Ų������������
			for(int i=0;i<testArray.length;i++)
			{
				if (ender==testArray.length-1){//�жϽ�����������Ԫ�ؽ�ջ
					
					if (testArray[ender]==')'){//������ʱ����ender-starter�ĳ��ȵı��������ּ���S2
						char temp1[]=new char[ender-starter];
						System.arraycopy(testArray,starter, temp1, 0,ender-starter);
						String t=new String(temp1);
						S2.push(t);
					}
					else{//����ender-starter+1�ĳ��ȵı��������ּ���S2����Ϊ���ڲ�����֮ǰ�������ǲ�������һ����
						char temp2[]=new char[ender-starter+1];
						System.arraycopy(testArray,starter, temp2, 0,ender-starter+1);
						String t=new String(temp2);
						S2.push(t);
					}
				}
				else{//�Բ�������ջ�����������ȵ��ж�
				   if(testArray[i]=='+'||testArray[i]=='-'||testArray[i]=='*'||testArray[i]=='/'||testArray[i]=='('||testArray[i]==')'||testArray[i]=='^')
				   {
					   if (i==0){//�����ʼ��������������˳�����
					   System.out.print("Error, no variable ");
					   System.exit(0); 
				   }
					   if (testArray[i]=='('){
						   starter+=1;
						   S1.push(testArray[i]);
					   }
					   else{
						ender = i;
						if (ender>starter){
						char temp[]=new char[ender-starter];
						System.arraycopy(testArray,starter, temp, 0,ender-starter);
						String t=new String(temp);
						S2.push(t);
						starter = ender+1;
						}
						if (S1.isEmpty())
							S1.push(testArray[i]);
							 
						else if (testArray[i]==')'){
						    S2.push(S1.peek());
							S1.pop();
							if (!S1.isEmpty()){
								while ((char)S1.peek()!='('){
									S2.push(S1.peek());
									S1.pop();
								}
								if ((char)S1.peek()!='(')
								   S1.pop();	
							}
							starter=starter+1;
							}
						   /*
							��������۲�������ջ����
							*/
							else if (testArray[i]=='*'||testArray[i]=='/')
							{
								if ((char)S1.peek()=='+'||(char)S1.peek()=='-'||(char)S1.peek()=='('){
									S1.push(testArray[i]);
								}
							
								else
								{
									S2.push(S1.peek());
									S1.pop();
									if (!S1.isEmpty()){
									    while ((char)S1.peek()=='*'||(char)S1.peek()=='/'||(char)S1.peek()=='^'){
										     S2.push(S1.peek());
										     S1.pop();
									    }
									}
									S1.push(testArray[i]);
								}
							}
						
							else if(testArray[i]=='^'){
								S1.push(testArray[i]);
							}
						
				            else if(testArray[i]=='+'||testArray[i]=='-')
							{
								if ((char)S1.peek()=='('){
									S1.push(testArray[i]);
								}
								
								else{
									S2.push(S1.peek());
									S1.pop();
									while(!S1.empty()){
										S2.push(S1.peek());
										S1.pop();
									}
									S1.push(testArray[i]);
								}
								
							}
					   }
				   }
				}
				   ender = ender+1;
				}
		
			while(!S1.isEmpty()){//���ʽ������ɺ�S1ʣ�µĲ�����ѹ��S2��
				if ((char)S1.peek()=='(')
					S1.pop();
				else{
					S2.push(S1.peek());
					S1.pop();
				}
			}
			
			for (int i=ender-1;i>=0;i--){
				if (!S2.isEmpty()){
				    arraytemp[i]=S2.peek().toString();
					S2.pop();//�����׺
				}
			}

			
			return arraytemp;//���õ��ĺ�׺���ʽ�����ַ�������
	 }
		 	

	  private static String simplify(String[] ARR,String test,String val)
	  {
		  int i=0,k=0,o=0;
		  int starter=0,ender=0;
		  String data=new String();
		  String word=new String();
		  String[] d=new String[2];
		  String result[]=new String[ARR.length];
		  Stack S3=new Stack();
		  char[] value=val.toCharArray();
		  for (int n=0;n<value.length;n++){
			  if (value[n]=='=')
				  starter=n+1;
		  }
		  ender=value.length;
		  char temp[]=new char[ender-starter];
		  String w=val.substring(0, 1);
		  System.arraycopy(value,starter, temp, 0,ender-starter);
		  String t=new String(temp);
		  
		  
		  while (i<ARR.length)
	      {
			  int h=0;
			  int q=0;
			  if (ARR[i]==null||ARR[i].equals("(")){//���������ý�������
				  i++;
			  }
			  else if (ARR[i].equals("+")||ARR[i].equals("-")||ARR[i].equals("*")||ARR[i].equals("/")||ARR[i].equals("^")){
				  //����������ʱ�������������
				  while(h<=1){
					 while(q<2){
					 int j=0;
				     char[] isword=String.valueOf(S3.peek()).toCharArray();
				     do{
					    if (isword[j]<=122&&isword[j]>=97){
					    	/*���������������ĸ�����Һ�����ı���һ��
					    	 ������ı���ֵ����ԭ����
					    	 */
						    if (w.equals(String.valueOf(S3.peek()))){
							    d[q]=t;
							    S3.pop(); 
							    
					        }
						  //�����ֲ�������˵��ջ��Ԫ�ز��ܲ������
						    else if (isword[j]=='+'||isword[j]=='-'||isword[j]=='*'||isword[j]=='/'||isword[j]=='^'){
						    	d[q]=String.valueOf(S3.peek());
						    	S3.pop();
						    }
						    //����ֱ�ӽ�ջ��Ԫ�ؽ�������
						    else{
						    	word=String.valueOf(S3.peek());
						    	d[q]=String.valueOf(S3.peek());
						    	S3.pop();
						    	j=isword.length;
						    }
						    j++;
						    h++;
						    q++;
					    }
					    else{
						    j++;
						    h++;
					    }
				    }while (j<isword.length);
				     //�����ж��Ƿ�ȡ��S3�����������������
				     if (q<2){
				    	 if(w.equals(String.valueOf(S3.peek()))){
				    		 d[q]=t;
				    	 }
				    	 else{
				    		 d[q]=String.valueOf(S3.peek());
				    		 }
						    S3.pop();
						    q++;
						    h++;
				     }
				  };
				  
				};
				  char[] is0=d[0].toCharArray();
				  char[] is1=d[1].toCharArray();
	
				  StringBuffer buffer=new StringBuffer();
				  int isjump=0;
				  //�ж��Ƿ����޷�����������ַ���
				  for (int g=0;g<is0.length;g++){
					  if (is0[g]<='z'&&is0[g]>='a')
						  isjump=1;
				  }
				  for (int g=0;g<is1.length;g++){
					  if (is1[g]<='z'&&is1[g]>='a')
						  isjump=1;
				  }
				  //�������ֱ�ӽ�S3�������Ԫ������������ջ
				  if (isjump==1){
					  buffer.append(d[1]+ARR[i]+d[0]);
					  data=buffer.toString();
				  }
				  //���������Ӧ������
				  else{
					  switch (ARR[i]){
					  case "+":
						  data=String.valueOf(Integer.parseInt(d[1])+Integer.parseInt(d[0]));
						  break;
					  case "-":
						  data=String.valueOf(Integer.parseInt(d[1])-Integer.parseInt(d[0]));
						  break;
					  case "*":
						  data=String.valueOf(Integer.parseInt(d[1])*Integer.parseInt(d[0]));
						  break;
					  case "/":
						  data=String.valueOf(Integer.parseInt(d[1])/Integer.parseInt(d[0]));
						  break;
					  case "^":
						  data=String.valueOf((int)(Math.pow(Integer.parseInt(d[1]),Integer.parseInt(d[0]))));
						  break;
				  }
				  }
			      
			  S3.push(data);
			  i++;
			  }
			 else {
				  S3.push(ARR[i]);
				  i++;
			  }
			 
	  }		 
		  
		  while(!S3.isEmpty()){
			  result[ARR.length-1]=String.valueOf(S3.peek());
			  S3.pop();
			  k++;
			}
		  String newtest=new String();
		  do{
			  if (result[o]!=null){
				  newtest=newtest+result[o];
				  System.out.println(result[o]+"\n");
			  }
			  o++;
		  }while(o<ARR.length);
		  return newtest;//���±��ʽ
  }  
	  
	  public static String ddx(String s,char x){
			int couter = 0, flag = 0;
			for (int i = 0; i < s.length(); i++) {
		           char  temp =  s.charAt(i);
		           if(temp == x){
		        	   couter++;
		        	   flag = 1;
		           }
		        }
			if(flag==1)
			{
				s = s.replaceFirst(String.valueOf(x), Integer.toString(couter));
			}
			else
			{
				s = "";
			}
			return s;
		}

		public static void derivative(String reader,char x)//�Ա��ʽ��
		{
			reader = reader.replaceAll("-", "~-");
			reader = reader.replaceAll("[+]", "~+");
			String oprator[] = reader.split("~");
			String output = "";
			for(String s: oprator) {
				   s = ddx(s,x);
				   if(s == null || s.length() <= 0)
					   {
						   continue;
					   }
				   else
					   {
					   output = output+s;
					   }
				   }
			
			if(output.charAt(0)=='+')
			{
				output = output.replaceFirst("[+]", "");
			}
			System.out.print(output+"\n");
		}
}
