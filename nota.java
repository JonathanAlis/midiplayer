//package teste;

public class nota
{

	    private String replily;
	    private float freq;
		private float comeco;
		private float duracao;
		private float amp;
		private String instrumento;
		private int notamid;
public nota()
{
}

public nota(float comeco, float duracao, float freq, float amp)
{

this.comeco=comeco;
this.duracao=duracao;
this.freq=freq;
this.amp=amp;
this.instrumento=null;
this.notamid=this.freqtomid();
this.replily=this.notalily();
}

public nota(float comeco, float duracao, float freq)
{

this.comeco=comeco;
this.duracao=duracao;
this.freq=freq;
this.amp=0.7f;
this.instrumento=null;
this.notamid=this.freqtomid();
this.replily=this.notalily();
}
/*
public nota(String lilypond)
{


this.duracao=duracao;
this.freq=freq;
this.amp=0.7f;
this.instrumento=null;
this.notamid=this.freqtomid();
this.replily=this.notalily();
}
*/
public void setFreq(float freq)
{
this.freq=freq;
}

public void setComeco(float comeco)
{
this.comeco=comeco;
}

public void setDuracao(float duracao)
{
this.duracao=duracao;
}

public void setAmp(float amp)
{
this.amp=amp;
}

public void setReplily(String replily)
{
this.replily=replily;
}

public void setInstrumento(String inst)
{
this.instrumento=inst;
}

public void setNotamid(int notamid)
{
this.notamid=notamid;
}
public float getFreq()
{
return this.freq;
}

public float getComeco()
{
return this.comeco;
}

public float getDuracao()
{
return this.duracao;
}

public float getAmp()
{
return this.amp;
}

public String getReplily()
{
return this.replily;
}

public String getInstrumento()
{
return this.instrumento;
}
public int getNotamid()
{
return this.notamid;
}

//la 440 = a' = mid 69
public int freqtomid()
{
return Math.round((float)(12*Math.log(this.freq/440.0f)/Math.log(2)))+69;
}

public String notalily()
{
String str="";
if(amp!=0)
{
switch(this.notamid%12)
	{
	case(0):str=str.concat("c");break;
	case(1):str=str.concat("cis");break;
	case(2):str=str.concat("d");break;
	case(3):str=str.concat("dis");break;
	case(4):str=str.concat("e");break;
	case(5):str=str.concat("f");break;
	case(6):str=str.concat("fis");break;
	case(7):str=str.concat("g");break;
	case(8):str=str.concat("gis");break;
	case(9):str=str.concat("a");break;
	case(10):str=str.concat("bes");break;
	case(11):str=str.concat("b");break;
	}
for(int i=4;i<this.notamid/12;i++)
	str=str.concat("'");
for(int i=4;i>this.notamid/12;i--)
	str=str.concat(",");
}
else str=str.concat("r");
return str;
}

public float midtofreq(int mid)
{
return (float)(440*Math.pow(2,(mid-69.0)/12.0));

}
public nota lilytonota(String notalily)
{

	int mid=0;
	switch(notalily.charAt(0))
		{
		case 'a':mid=57;break;
		case 'b':mid=59;break;
		case 'c':mid=48;break;
		case 'd':mid=50;break;
		case 'e':mid=52;break;
		case 'f':mid=53;break;
		case 'g':mid=55;break;
		case 'r':mid=66;amp=0.0f;break;
		}
//System.out.print(notalily+" -> "+mid+" que vira ");
	int i=0;
	if(notalily.length()>1)
	{try{
		while(Character.isLetter(notalily.charAt(i))) i++;
		if(notalily.substring(1,i).equals("is"))mid++;
		if(notalily.substring(1,i).equals("es"))mid--;
		if(notalily.substring(1,i).equals("isis"))mid+=2;
		if(notalily.substring(1,i).equals("eses"))mid-=2;
	
		if(((Character)notalily.charAt(i))==',')
			{int j=0;
			while(((Character)notalily.charAt(i))==',') 
			{
			j++;
			i++;
			if(i==notalily.length())break;
			}
			mid-=12*j;
			}
		else if(((Character)notalily.charAt(i))=='\'')
			{int j=0;//i outofbounds
		
			while(((Character)notalily.charAt(i))=='\'') 
			{
			j++;
			i++;
			if(i==notalily.length())break;
			}
			mid+=12*j;
			}
	}
	catch(StringIndexOutOfBoundsException e){};
	}
	float duracao=1.0f;	
	i=0;
	while(!Character.isDigit(notalily.charAt(i)) && i<notalily.length()-1)i++;
	if(i<notalily.length())
	try{
	if(Integer.parseInt(notalily.substring(i))!=0)
	duracao=4.0f/Integer.parseInt(notalily.substring(i));
	else duracao = 4;
	
	}catch(NumberFormatException e){}
//	System.out.print(" "+mid+"\n");
float freq=midtofreq(mid);
nota ret=new nota(-1,duracao,freq);
ret.setReplily(notalily);
return ret;

}

void printNota()
{
System.out.println("Em lilypond: "+this.replily);
System.out.println("frequencia: "+this.freq);
System.out.println("inicia em: "+this.comeco);
System.out.println("duracao: "+this.duracao);
System.out.println("Amplitude: "+this.amp);
System.out.println("Instrumento: "+this.instrumento);
System.out.println("Representacao midi: "+this.notamid+"\n");
}
}
