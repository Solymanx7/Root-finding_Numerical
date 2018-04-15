/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical;

import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import net.objecthunter.exp4j.*;

/**
 *
 * @author RYNI
 */
public class Numerical extends Application {
     final KeyCombination keyCombinationShiftC = new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.SHIFT_DOWN);
     
    @Override
    public void start(Stage primaryStage) {
//Creating TabPane
        TabPane tabPane = new TabPane();
        tabPane.setPrefWidth(800);
        //--------------------------------------------
        
        //Creating Tabs[Bi,Sec,MSec]
        Tab Bi_tab = new Tab();
        Tab Sec_tab = new Tab();
        Tab MSec_tab = new Tab();
        Tab table_tab = new Tab();
        
        
        TableView <Row> table = new TableView<Row>();
        TableView <Row> Bisection_table = new TableView<Row>();
        TableView <Row> Secant_table = new TableView<Row>();
        TableView <Row> ModifiedSecant_table = new TableView<Row>();
        
        
        Bisection_table.setPrefSize(800, 370);
        Secant_table.setPrefSize(800, 370);
        ModifiedSecant_table.setPrefSize(800, 370);
        table.setPrefSize(800, 370);

        Bi_tab.setText("Bisection");
        Bi_tab.setClosable(false);
        Bi_tab.setContent(Bisection_table);
        
        
        
        Sec_tab.setText("Secant");
        Sec_tab.setClosable(false);
        Sec_tab.setContent(Secant_table);
        

        
        MSec_tab.setText("Modified Secant");
        MSec_tab.setClosable(false);
        MSec_tab.setContent(ModifiedSecant_table);
        
        
        table_tab.setText("Test");
        table_tab.setClosable(false);
        table_tab.setContent(table);
        
        
        TableColumn  i_col1 = new TableColumn("i");
        TableColumn  A_col1 = new TableColumn("a");
        TableColumn  B_col1 = new TableColumn("b");
        TableColumn  C_col1 = new TableColumn("c");
        TableColumn  Fa_col1 = new TableColumn("F(a)");
        TableColumn  Fb_col1 = new TableColumn("F(b)");
        TableColumn  Fc_col1 = new TableColumn("F(c)");
        TableColumn  Cond_col1 = new TableColumn("|F(c)|<=Tol");
        
        i_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("i")
        );
        
         A_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("a")
        );
         
         B_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("b")
        );
         
          C_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("c")
        );
          
          Fa_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FA")
        );
          
          Fb_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FB")
        );
          
          Fc_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FC")
        );
           Cond_col1.setCellValueFactory(
         new PropertyValueFactory<Row,String>("CND")
        );
          
        
        table.getColumns().addAll(i_col1,A_col1,B_col1,C_col1,Fa_col1,Fb_col1,Fc_col1,Cond_col1);
         
        TableColumn  i_col = new TableColumn("i");
        TableColumn  A_col = new TableColumn("a");
        TableColumn  B_col = new TableColumn("b");
        TableColumn  C_col = new TableColumn("c");
        TableColumn  Fa_col = new TableColumn("F(a)");
        TableColumn  Fb_col = new TableColumn("F(b)");
        TableColumn  Fc_col = new TableColumn("F(c)");
        TableColumn  Cond_col = new TableColumn("|F(c)|<=Tol");
        
   
         i_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("i")
        );
        
         A_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("a")
        );
         
         B_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("b")
        );
         
          C_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("c")
        );
          
          Fa_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FA")
        );
          
          Fb_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FB")
        );
          
          Fc_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FC")
        );
          
          Cond_col.setCellValueFactory(
         new PropertyValueFactory<Row,String>("CND")
        );
          
        TableColumn  i_col2 = new TableColumn("i");
        TableColumn  A_col2 = new TableColumn("a");
        TableColumn  B_col2 = new TableColumn("b");
        TableColumn  C_col2 = new TableColumn("c");
        TableColumn  Fa_col2 = new TableColumn("F(a)");
        TableColumn  Fb_col2 = new TableColumn("F(b)");
        TableColumn  Fc_col2 = new TableColumn("F(c)");
        TableColumn  Cond_col2 = new TableColumn("|F(c)|<=Tol");
        
   
         i_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("i")
        );
        
         A_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("a")
        );
         
         B_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("b")
        );
         
          C_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("c")
        );
          
          Fa_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FA")
        );
          
          Fb_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FB")
        );
          
          Fc_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FC")
        );
          
          Cond_col2.setCellValueFactory(
         new PropertyValueFactory<Row,String>("CND")
        );
          
        TableColumn  i_col3 = new TableColumn("i");
        TableColumn  A_col3 = new TableColumn("a");
        TableColumn  B_col3 = new TableColumn("b");
        TableColumn  C_col3 = new TableColumn("c");
        TableColumn  Fa_col3 = new TableColumn("F(a)");
        TableColumn  Fb_col3 = new TableColumn("F(b)");
        TableColumn  Fc_col3 = new TableColumn("F(c)");
        TableColumn  Cond_col3 = new TableColumn("|F(c)|<=Tol");
        
   
         i_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("i")
        );
        
         A_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("a")
        );
         
         B_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("b")
        );
         
          C_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("c")
        );
          
          Fa_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FA")
        );
          
          Fb_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FB")
        );
          
          Fc_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("FC")
        );
          
          Cond_col3.setCellValueFactory(
         new PropertyValueFactory<Row,String>("CND")
        );
          
        Bisection_table.getColumns().addAll(i_col,A_col,B_col,C_col,Fa_col,Fb_col,Fc_col,Cond_col);
        Secant_table.getColumns().addAll(i_col2,A_col2,B_col2,C_col2,Fa_col2,Fb_col2,Fc_col2,Cond_col2);
        ModifiedSecant_table.getColumns().addAll(i_col3,A_col3,B_col3,C_col3,Fa_col3,Fb_col3,Fc_col3,Cond_col3);
        
        Fa_col.setPrefWidth(130);
        Fb_col.setPrefWidth(130);
        Fc_col.setPrefWidth(130);
        
        Fa_col2.setPrefWidth(130);
        Fb_col2.setPrefWidth(130);
        Fc_col2.setPrefWidth(130);
        
        
        Fa_col3.setPrefWidth(130);
        Fb_col3.setPrefWidth(130);
        Fc_col3.setPrefWidth(130);
        
        
        tabPane.setTabMinWidth(100);
        tabPane.getTabs().addAll(Bi_tab,Sec_tab,MSec_tab);
        //--------------------------------------------

        //F(x) HBox[Label + TextField]
        HBox hboxFx = new HBox();

        Label Fx_L = new Label("F(x) = ");
        Fx_L.setPadding(new Insets(4,0,0,0));
        Fx_L.setFont(new Font("Arial",14));
        Fx_L.setStyle("-fx-font-weight: bold");
        
        TextField Fx_TxtField = new TextField();
        Fx_TxtField.setText("sin(x)-x^3"); //Virtual 1
        Fx_TxtField.setFont(new Font("Arial",13));
        Fx_TxtField.setPrefWidth(300);
        
        Fx_TxtField.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        if (keyCombinationShiftC.match(event)) {
            //Fx_TxtField.setText(Fx_TxtField.getText() );
            System.out.println("Shift + ^ Pressed");
        }
            }
                                 });
        
        hboxFx.getChildren().addAll(Fx_L,Fx_TxtField);
        //--------------------------------------------
        
        //A HBox[Label + TextField]
        HBox hboxA = new HBox();
    
        Label A_L = new Label("A = ");
        A_L.setPadding(new Insets(4,0,0,0));
        A_L.setFont(new Font("Arial",14));
        A_L.setStyle("-fx-font-weight: bold");
        
        TextField A_TxtField = new TextField();
        A_TxtField.setText("0.5");
        A_TxtField.setFont(new Font("Arial",13));
        A_TxtField.setPrefWidth(80);
        
        hboxA.getChildren().addAll(A_L,A_TxtField);
        //--------------------------------------------
        
        //B HBox[Label + TextField]
        HBox hboxB = new HBox();
    
        Label B_L = new Label("B = ");
        B_L.setPadding(new Insets(4,0,0,0));
        B_L.setFont(new Font("Arial",14));
        B_L.setStyle("-fx-font-weight: bold");
        
        TextField B_TxtField = new TextField();
        B_TxtField.setText("1");
        B_TxtField.setFont(new Font("Arial",13));
        B_TxtField.setPrefWidth(80);
        
        hboxB.getChildren().addAll(B_L,B_TxtField);
        //--------------------------------------------
        
        //Tolerance HBox[Label + TextField]
        HBox hboxTol = new HBox();
    
        Label Tol_L = new Label("Tol = ");
        Tol_L.setPadding(new Insets(4,0,0,0));
        Tol_L.setFont(new Font("Arial",14));
        Tol_L.setStyle("-fx-font-weight: bold");
        
        TextField Tol_TxtField = new TextField();
        Tol_TxtField.setText("0.01");
        Tol_TxtField.setFont(new Font("Arial",13));
        Tol_TxtField.setPrefWidth(60);
        
        hboxTol.getChildren().addAll(Tol_L,Tol_TxtField);
        //--------------------------------------------
        
        //Hbox contains [hboxFx,hboxA,hboxB]
        HBox FxAB = new HBox();
        FxAB.setSpacing(30);
        FxAB.setPadding(new Insets(10, 0, 0,0));
        FxAB.getChildren().addAll(hboxFx,hboxA,hboxB,hboxTol);
        //--------------------------------------------
        
        
        
        //Check Fields[All + Bisection + Secant + Modified Secant]
         HBox Chk;
         String Chk_Style =  "-fx-font-size: 14;"+"-fx-border-insets: -5; " ;
         
         
         CheckBox Bisection_Chk = new CheckBox("Bisection");
         Bisection_Chk.setStyle(Chk_Style);
         CheckBox Secant_Chk = new CheckBox("Secant");
         Secant_Chk.setStyle(Chk_Style);
         CheckBox ModifiedSecant_Chk = new CheckBox("ModifiedSecant");
         ModifiedSecant_Chk.setStyle(Chk_Style);
         
         
         CheckBox All_Chk = new CheckBox("All");
         
         Bisection_Chk.setSelected(true);
         Secant_Chk.setSelected(true);
         ModifiedSecant_Chk.setSelected(true);
         All_Chk.setSelected(true);
         
         
         All_Chk.setStyle(Chk_Style);
         All_Chk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Bisection_Chk.setSelected(true);
                Secant_Chk.setSelected(true);
                ModifiedSecant_Chk.setSelected(true);
                if(!All_Chk.isSelected())
                {
                Bisection_Chk.setSelected(false);
                Secant_Chk.setSelected(false);
                ModifiedSecant_Chk.setSelected(false);
                }
            }
        });
        //--------------------------------------------
         
        //Hbox contains [All_Chk,Bisection_Chk,Secant_Chk,ModifiedSecant_Chk]
        Chk = new HBox();
        Chk.setTranslateX(10);
        Chk.setAlignment(Pos.CENTER);
        Chk.setSpacing(30);
        Chk.getChildren().addAll(All_Chk,Bisection_Chk,Secant_Chk,ModifiedSecant_Chk);
        //--------------------------------------------
        
        //Calculate Button
        Button Calc_Button = new Button("Calculate");
        Calc_Button.setTranslateX(500);
        Calc_Button.setOnAction((event) -> 
        {
            String Fx = Fx_TxtField.getText();
             Alert alert = new Alert(Alert.AlertType.ERROR);
             if(Fx_TxtField.getText().isEmpty() || A_TxtField.getText().isEmpty() || B_TxtField.getText().isEmpty() || Tol_TxtField.getText().isEmpty())
             {
                
                 alert.setTitle("Error");
                 alert.setHeaderText("Input Error");
                 alert.setContentText("Pleases , don't leave any input blank !");
                 alert.showAndWait();
                 return;
             }
             double Fa = CalculateFx(Fx, Double.parseDouble(A_TxtField.getText()));
             double Fb = CalculateFx(Fx, Double.parseDouble(B_TxtField.getText()));
             if(Fa*Fb >=0)
             {
                 alert.setTitle("Error");
                 alert.setHeaderText("Input Error");
                 alert.setContentText("Pleases , Check your interval !");
                 alert.showAndWait();
                 return;
             }
             
             
             
             
             

            
            Bisection_table.getItems().clear();
            Secant_table.getItems().clear();
            ModifiedSecant_table.getItems().clear();
            
             
             double Tol = Double.parseDouble(Tol_TxtField.getText());
             double a,b,c,fa,fb,fc;
             int i;
             String si,sa,sb,sc,sfa,sfb,sfc;
             String cond;
             
                         
        
             
       

        if(Bisection_Chk.isSelected())
        {
            a= Double.parseDouble(A_TxtField.getText());
            b= Double.parseDouble(B_TxtField.getText());
            double NoOfIterations;
            NoOfIterations = CalculateFx("log2(x)",( Math.abs(b-a) ) / Tol);
            System.out.println("Num of maximum iterations Bisection: "+(int)NoOfIterations);
            i=1;
            while(i<5)
            {
                c = (a+b)/2;
                fa = CalculateFx(Fx, a);
                fb = CalculateFx(Fx, b);
                fc = CalculateFx(Fx, c);
                
                si= Integer.toString(i);
                sa= Double.toString(a);
                sb= Double.toString(b);
                sc= Double.toString(c);
                sfa= Double.toString(fa);
                sfb= Double.toString(fb);
                sfc= Double.toString(fc);

                
                if(Math.abs(fc) <= Tol )
                {
                    cond = "True";
                   
                    Bisection_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                    break;
                }
                else
                {
                cond = "False";
                 Bisection_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                 if(fc * fb <0)// Root Between fc&fb
                 {
                     fa = fc;
                     a = c;
                 }
                 else if(fc * fa <0)// Root Between fc&fa
                 {
                     fb = fc;
                     b = c;
                 }
                    
                }
                i++;
            }
            
        }
  
        if(Secant_Chk.isSelected())
        {
            a= Double.parseDouble(A_TxtField.getText());
            b= Double.parseDouble(B_TxtField.getText());
             i=1;
            while(i<5)
            {
                fa = CalculateFx(Fx, a);
                fb = CalculateFx(Fx, b);
                c = b-fb*( (b-a) / (fb-fa) );
                
                fc = CalculateFx(Fx, c);
                
                si= Integer.toString(i);
                sa= Double.toString(a);
                sb= Double.toString(b);
                sc= Double.toString(c);
                sfa= Double.toString(fa);
                sfb= Double.toString(fb);
                sfc= Double.toString(fc);

                
                if(Math.abs(fc) <= Tol )
                {
                    cond = "True";
                   
                    Secant_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                    break;
                }
                else
                {
                cond = "False";
                 Secant_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                 fa = fb;
                 fb = fc;
                 a=b;
                 b=c;
                    
                }
                i++;
            }
            
        }
        if(ModifiedSecant_Chk.isSelected())
        {
            a= Double.parseDouble(A_TxtField.getText());
            b= Double.parseDouble(B_TxtField.getText());
             i=1;
            while(i<5)
            {
                fa = CalculateFx(Fx, a);
                fb = CalculateFx(Fx, b);
                c = b-fb*( (b-a) / (fb-fa) );
                
                fc = CalculateFx(Fx, c);
                
                si= Integer.toString(i);
                sa= Double.toString(a);
                sb= Double.toString(b);
                sc= Double.toString(c);
                sfa= Double.toString(fa);
                sfb= Double.toString(fb);
                sfc= Double.toString(fc);

                
                if(Math.abs(fc) <= Tol )
                {
                    cond = "True";
                   
                    ModifiedSecant_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                    break;
                }
                else
                {
                cond = "False";
                 ModifiedSecant_table.getItems().add(new Row(si, sa, sb, sc, sfa, sfb, sfc, cond));
                 if(fc * fb <0)// Root Between fc&fb
                 {
                     fa = fc;
                     a = c;
                 }
                 else if(fc * fa <0)// Root Between fc&fa
                 {
                     fb = fc;
                     b = c;
                 }
                    
                }
                i++;
            } 
        }
        
                });
        //--------------------------------------------
        
        //VBox contains [FxAB,Chk,Calc_Button]
        VBox FxAB_Chk = new VBox();
        FxAB_Chk.setPadding(new Insets(0, 0, 0,10));
        FxAB_Chk.setSpacing(25);
        FxAB_Chk.getChildren().addAll(FxAB,Chk,Calc_Button);
        //--------------------------------------------
       
       
        
        
        //VBox contains [tabPane,FxAB_Chk]
        VBox Top_Bot = new VBox();
        Top_Bot.setSpacing(30);
        Top_Bot.getChildren().addAll(FxAB_Chk,tabPane);
        //--------------------------------------------
        
        
        
        
        
        FlowPane root = new FlowPane();
        //root.setPadding(new Insets(0, 0, 0,10));
        root.getChildren().addAll(Top_Bot);
        
        Scene scene = new Scene(root, 790, 550);
        
        primaryStage.setTitle("Numerical | Bisection , Secant & Modified Secant");
        primaryStage.setScene(scene);
        //primaryStage.set
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static double CalculateFx(String Fx , double x)
    {
        Expression NumberE = new ExpressionBuilder(Fx)
                .variables("x","X")
                .build()
                .setVariable("x", x)
                .setVariable("X", x);
                
        double Num = NumberE.evaluate();
        
        return Num;
        
    }
}
