package java_tictactoe_game;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import tictactoe.PlayResult;
import tictactoe.exception.InvalidPositionException;
import tictactoe.exception.SpotUnavailableException;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class TicTacToe_Game extends javax.swing.JFrame {
    private HashMap componentMap;
    private char lastPlayer = 'O';
     
    public TicTacToe_Game() {
        initComponents();
        addAction();
        setLocationRelativeTo(null);
        createComponentMap();
    }
    
    
    
    //Esta funcion ejecuta un turno. Ojo: solo para pruebas
    public PlayResult play(int row, int column) {
        checkPosition(row);
        checkPosition(column);
        int num = column+((row-1)*3);
        JButton button = (JButton) getComponentByName("jButton"+Integer.toString(num));
        if(button.getText().equals("")){
            if(lastPlayer == 'O')
                {
                    button.setText("X");
                    button.setForeground(Color.BLUE);
                    jLabelMSG.setText("Turno de O");
                    lastPlayer = 'X';
                    getTheWinner();
                }else{
                    button.setText("O");
                    button.setForeground(Color.RED);
                    jLabelMSG.setText("Turno de X");
                    getTheWinner();
                    lastPlayer = 'O';
                }

        }else
            throw new SpotUnavailableException("This spot has already been taken");     

        return getTheWinner();
    }
    
    private void checkPosition(int position) {
        if (position < 1 || position > 3)
            throw new InvalidPositionException("The position played is invalid!");
    }
    
    public void winEffect(JButton b1, JButton b2, JButton b3)
    {
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b3.setBackground(Color.BLACK);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        
        String msg = b1.getText() + " Es el ganador";
        jLabelMSG.setText(msg);
        
    }
    
    boolean win = false;
    public PlayResult getTheWinner(){
        
        if(!jButton1.getText().equals("") && jButton1.getText().equals(jButton2.getText()) && jButton1.getText().equals(jButton3.getText())){
            winEffect(jButton1, jButton2, jButton3);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton4.getText().equals("") && jButton4.getText().equals(jButton5.getText()) && jButton4.getText().equals(jButton6.getText())){
            winEffect(jButton4, jButton5, jButton6);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton7.getText().equals("") && jButton7.getText().equals(jButton8.getText()) && jButton7.getText().equals(jButton9.getText())){
            winEffect(jButton7, jButton8, jButton9);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton1.getText().equals("") && jButton1.getText().equals(jButton4.getText()) && jButton1.getText().equals(jButton7.getText())){
            winEffect(jButton1, jButton4, jButton7);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton2.getText().equals("") && jButton2.getText().equals(jButton5.getText()) && jButton2.getText().equals(jButton8.getText())){
           winEffect(jButton2, jButton5, jButton8);
           win = true;
           return PlayResult.WINNER;
        }
        
        if(!jButton3.getText().equals("") && jButton3.getText().equals(jButton6.getText()) && jButton3.getText().equals(jButton9.getText())){
            winEffect(jButton3, jButton6, jButton9);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton1.getText().equals("") && jButton1.getText().equals(jButton5.getText()) && jButton1.getText().equals(jButton9.getText())){
            winEffect(jButton1, jButton5, jButton9);
            win = true;
            return PlayResult.WINNER;
        }
        
        if(!jButton3.getText().equals("") && jButton3.getText().equals(jButton5.getText()) && jButton3.getText().equals(jButton7.getText())){
            winEffect(jButton3, jButton5, jButton7);
            win = true;
        }
        
        else if(allButtonsTextLength() == 9 && win == false){
            jLabelMSG.setText("Empate");
            return PlayResult.DRAW;
        }
        
        return PlayResult.NO_WINNER;
    }
    
    // if no one win
    public int allButtonsTextLength(){
        
        String txt = "";
        
        Component[] comps = jPanel2.getComponents();
        
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton button = (JButton)comp;
                 txt = txt + button.getText();
            }
        }
        return txt.length();
    }
    
        
    public ActionListener createAction(JButton button)
    {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(button.getText().equals("")){
                    if(lastPlayer == 'O')
                        {
                            button.setText("X");
                            button.setForeground(Color.BLUE);
                            jLabelMSG.setText("Turno de O");
                            lastPlayer = 'X';
                            getTheWinner();
                        }else{
                            button.setText("O");
                            button.setForeground(Color.RED);
                            jLabelMSG.setText("Turno de X");
                            getTheWinner();
                            lastPlayer = 'O';
                        }
                         
                }else
                    throw new SpotUnavailableException("This spot has already been taken");
                
            }
            
        };
        return al;
    }      
    
    public void addAction(){
        
        Component[] comps = jPanel2.getComponents();
        
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton button = (JButton)comp;
                button.addActionListener(createAction(button));
            }
        }
        
    }
    
    public char getLastPlayer() {
        return lastPlayer;
    }
    public char nextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMSG = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButtonReplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 38, 19));

        jLabelMSG.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMSG.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMSG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSG.setText("TIC TAC TOE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMSG, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMSG, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton5.setName("jButton5"); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton6.setName("jButton6"); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton7.setName("jButton7"); // NOI18N

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton8.setName("jButton8"); // NOI18N

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton9.setName("jButton9"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButtonReplay.setBackground(new java.awt.Color(65, 131, 215));
        jButtonReplay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonReplay.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReplay.setText("Jugar de nuevo");
        jButtonReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButtonReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReplayActionPerformed
        
        win = false;        
        Component[] comps = jPanel2.getComponents();
        
        for(Component comp : comps){
            if(comp instanceof JButton){
                
                
                JButton button = (JButton)comp;
                
                button.setText("");
                button.setBackground(Color.WHITE);
                jLabelMSG.setText("TIC TAC TOE");
            }
        }
        
    }//GEN-LAST:event_jButtonReplayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe_Game().setVisible(true);
            }
        });
    }
    
    private void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] components = jPanel2.getComponents();
        for (int i=0; i < components.length; i++) {
                componentMap.put(components[i].getName(), components[i]);
        }
    }

    public Component getComponentByName(String name) {
            if (componentMap.containsKey(name)) {
                    return (Component) componentMap.get(name);
            }
            else return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonReplay;
    private javax.swing.JLabel jLabelMSG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
