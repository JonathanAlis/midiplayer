/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * teste.java
 *
 * Created on 13/12/2009, 01:30:30
 */

//package teste;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.swing.JFileChooser;


/**
 *
 * @author jonathan
 */
public class teste extends javax.swing.JFrame {

    private Sequencer seq;
    private File arqmidi;
    private long tick=0;
    private boolean repetir=false;
    /** Creates new form teste */
    public teste() throws MidiUnavailableException {
        initComponents();
        seq = MidiSystem.getSequencer();
        //if(seq.isRunning())atualiza();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        bplay = new javax.swing.JButton();
        bpause = new javax.swing.JButton();
        bstop = new javax.swing.JButton();
        babrir = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField1 = new javax.swing.JTextField();
        barra = new javax.swing.JProgressBar();
        velocidade = new javax.swing.JSlider();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("Player");

        bplay.setText("Play");
        bplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bplayActionPerformed(evt);
            }
        });

        bpause.setText("Pause");
        bpause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpauseActionPerformed(evt);
            }
        });

        bstop.setText("Stop");
        bstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstopActionPerformed(evt);
            }
        });

        babrir.setText("Abrir midi");
        babrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                babrirActionPerformed(evt);
            }
        });

        jFormattedTextField1.setText("Escolha um arquivo");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Informações");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        barra.setAutoscrolls(true);
        barra.setString("40%");
        barra.setStringPainted(true);
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barraMouseEntered(evt);
            }
        });
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                barraAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        velocidade.setMaximum(400);
        velocidade.setMinimum(25);
        velocidade.setPaintLabels(true);
        velocidade.setPaintTicks(true);
        velocidade.setSnapToTicks(true);
        velocidade.setToolTipText("Velocidade");
        velocidade.setValue(100);
        velocidade.setValueIsAdjusting(true);
        velocidade.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                velocidadeMouseDragged(evt);
            }
        });

        jCheckBox1.setText("Repetir");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bpause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bstop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(babrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(velocidade, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addComponent(babrir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(velocidade, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bplay)
                    .addComponent(bpause)
                    .addComponent(bstop)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bplayActionPerformed
        // TODO add your handling code here:
       if(!seq.isRunning()){
           seq.setTickPosition(tick);
           if(repetir)
               seq.setLoopCount(10);
           else
               seq.setLoopCount(0);
           seq.start();
           barra.setMinimum(0);
           barra.setMaximum((int) seq.getTickLength());
       }else{seq.setTickPosition(0);
           seq.start();}
        

}//GEN-LAST:event_bplayActionPerformed

    private void babrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_babrirActionPerformed
        try {
            // TODO add your handling code here:
            JFileChooser fc = new JFileChooser();
            // ... initialization code for the filechooser eg. fc.setCurrentDirectory(...)
            // Let's pop it up:
            int returnVal = fc.showOpenDialog(new Component() {
            });
            tick=0;
            // Here it is closed. What is chosen?
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                arqmidi = fc.getSelectedFile();
            }
            if(arqmidi.getName().endsWith(".mid"))
                seq.setSequence(MidiSystem.getSequence(arqmidi));
                
            else if(arqmidi.getName().endsWith(".car"))
                seq.setSequence(soma2mid(arqmidi));

            try {
                seq.open();
                jFormattedTextField1.setText("Arquivo aberto:\n"+arqmidi.getName());
                jTextField1.setText("BPM: "+seq.getTempoInBPM()+", semínima: "+seq.getSequence().getResolution()+" ticks = "+seq.getTempoInMPQ()/1000000 +"s");//+", tempofactor"+seq.getTempoFactor()+" "+seq.getTickLength()%(seq.getSequence().getResolution()*16));
            

            } catch (MidiUnavailableException ex) {
                Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_babrirActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void bpauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpauseActionPerformed
        // TODO add your handling code here:
        if(seq.isRunning()){
        tick=seq.getTickPosition();
        seq.stop();
        }
    }//GEN-LAST:event_bpauseActionPerformed

    private void bstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstopActionPerformed
        // TODO add your handling code here:
        if(seq.isRunning()){
        tick=0;
        seq.stop();
        }
    }//GEN-LAST:event_bstopActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void barraAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_barraAncestorMoved
        // TODO add your handling code here:
//        this.atualiza();
    }//GEN-LAST:event_barraAncestorMoved

    private void barraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseEntered
        // TODO add your handling code here:
        this.atualiza();
    }//GEN-LAST:event_barraMouseEntered

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        // TODO add your handling code here:
        this.atualiza();
    }//GEN-LAST:event_barraMouseDragged

    private void velocidadeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_velocidadeMouseDragged
        // TODO add your handling code here:
        seq.setTempoFactor(velocidade.getValue()/100.0f);
        this.atualiza();
    }//GEN-LAST:event_velocidadeMouseDragged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(repetir)repetir=false;
        else repetir=true;
        if(repetir)
               seq.setLoopCount(10);
           else
               seq.setLoopCount(0);
    }//GEN-LAST:event_jCheckBox1ActionPerformed







    public void atualiza()
    {
    barra.setValue((int) seq.getTickPosition());
        
        barra.setString(String.format("%2d:%2d:%2d\n",seq.getMicrosecondPosition()/60000000,(seq.getMicrosecondPosition()/1000000)%60,(seq.getMicrosecondPosition()/1000)%1000)+" / "+String.format("%2d:%2d:%2d\n",seq.getMicrosecondLength()/60000000,(seq.getMicrosecondLength()/1000000)%60,(seq.getMicrosecondLength()/1000)%1000));
        barra.updateUI();
 
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    teste t=new teste();
                    t.setVisible(true);
                   // while(true)
                    {
                    t.atualiza();
                    }
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton babrir;
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton bpause;
    private javax.swing.JButton bplay;
    private javax.swing.JButton bstop;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel titulo;
    private javax.swing.JSlider velocidade;
    // End of variables declaration//GEN-END:variables
static Sequence soma2mid(File nome) throws InvalidMidiDataException
{
boolean exe=false;
lista instrumentos=new lista();
lista notas=new lista();
float t1=0, t2=0, Fa=44100, A=1, T=0, N=1;
int L;
try {
     BufferedReader in = new BufferedReader(new FileReader(nome));
     String linha;
	System.out.println("Instrumentos detectados: ");

     while ((linha = in.readLine()) != null)
	{
		if (linha.startsWith(";")) continue;

		if(linha.startsWith("(val")||linha.startsWith("(VAL"))
		{
		linha=linha.substring(5,linha.length()-1);
		StringTokenizer valargs = new StringTokenizer(linha);
		t1=Float.parseFloat(valargs.nextToken());
		t2=Float.parseFloat(valargs.nextToken());
		Fa=Float.parseFloat(valargs.nextToken());
		A=Float.parseFloat(valargs.nextToken());
		T=Float.parseFloat(valargs.nextToken());
		N=Float.parseFloat(valargs.nextToken());

		}

		if (linha.startsWith("(INS")||linha.startsWith("(ins"))
		{
			int i=5;
			while(!Character.isLetter(linha.charAt(i)))
				i++;
			linha=linha.substring(i);

			i=0;
			while(linha.charAt(i)!=' ' && linha.charAt(i)!='\n'&& linha.charAt(i)!='\t' && linha.charAt(i)!='(' && i<linha.length()-1)
				i++;
			if(i<linha.length()-1)
			{instrumentos.acrescentaItem(linha.substring(0,i));	System.out.println(linha.substring(0,i));}
			else {instrumentos.acrescentaItem(linha.substring(0,i+1));	System.out.println(linha.substring(0,i+1));}

		}

		if (linha.startsWith("(EXE")||linha.startsWith("(exe"))
		{exe=true;
		for(int i=0;i<instrumentos.tamanho();i++)
		notas.acrescentaItem(new lista());
		}
		if (exe)
		{
			for(int i=0;i<instrumentos.tamanho();i++)
			{int j=0;
			if(-1!=(j=linha.indexOf((String)instrumentos.enesimoItem(i))))
				{
				linha=linha.substring(j+((String)instrumentos.enesimoItem(i)).length(),linha.indexOf(')'));
				System.out.println(linha);
				StringTokenizer args = new StringTokenizer(linha);
				float tempo=0;
				if(((lista)notas.enesimoItem(i)).tamanho()!=0)
				tempo=((nota)((lista)notas.enesimoItem(i)).primoItem()).getComeco()+((nota)((lista)notas.enesimoItem(i)).primoItem()).getDuracao();
				float tempo2=A*Float.parseFloat(args.nextToken());
				float tempo3=A*Float.parseFloat(args.nextToken());
				if(tempo2>tempo)
					{
					nota n=new nota(tempo,tempo2,220,0);
					n.setInstrumento((String)instrumentos.enesimoItem(i));
					((lista)notas.enesimoItem(i)).acrescentaItem(n);
					}
				nota n=new nota(tempo2,tempo3,Float.parseFloat(args.nextToken()),N*Float.parseFloat(args.nextToken()));
				n.setInstrumento((String)instrumentos.enesimoItem(i));
	//tratar transposição depois aqui.
				((lista)notas.enesimoItem(i)).acrescentaItem(n);

				}
			}
		}
     }
     in.close();

 } catch (IOException e) {
 }

for(int i=0;i<notas.tamanho();i++)
{
((lista)notas.enesimoItem(i)).reverte();
}
Sequence seq=new Sequence(0.0f, 96);
   try {
     FileOutputStream fos= new FileOutputStream((nome.getName().substring(0,nome.getName().length()-3)+"mid"));
try{
System.out.println("Gravando agora "+notas.tamanho()+" tracks.");
ShortMessage sm1;
ShortMessage sm2;
    for(int i=0;i<notas.tamanho();i++)
        		{

		seq.createTrack();
		long tick=0;
        int canal=0;
        System.out.println("Track "+i+" tem "+((lista)notas.enesimoItem(i)).tamanho()+" notas");
		for(int j=0;j<((lista)notas.enesimoItem(i)).tamanho();j++)
			{
            if(j>0) {
            if(((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getComeco()==((nota)((lista)notas.enesimoItem(i)).enesimoItem(j-1)).getComeco())
                 canal++;
            else canal=0;
            }
            
            sm1=new ShortMessage();
            sm2=new ShortMessage();

            tick=(long)(((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getComeco()*96);
            sm1.setMessage(ShortMessage.NOTE_ON,canal,((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getNotamid(),100);
                    //((int)((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getAmp()*128)%128);
           
            seq.getTracks()[i].add(new MidiEvent(sm1,tick));
            tick+=(long)(((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getDuracao()*96);
			sm2.setMessage(ShortMessage.NOTE_ON,canal,((nota)((lista)notas.enesimoItem(i)).enesimoItem(j)).getNotamid(),0);
            seq.getTracks()[i].add(new MidiEvent(sm2,tick));
               
			}System.out.println("n de eventos: "+seq.getTracks()[i].size());


		}
    }catch (javax.sound.midi.InvalidMidiDataException ex)
    {System.out.println("Erro na track");}
    if(MidiSystem.isFileTypeSupported(1, seq))
        MidiSystem.write(seq,1,fos);
          fos.close();
    }
    catch(IOException e){
        // possiveis erros são tratados aqui
    }

return seq;
}
}
