/*
Here's what I'm stuck on: 
deleting Threads (also in the GUI) (It only System.out.printl() the last item), 
opening other GUIs on threads (ConcurrentModel,java), 
opening other GUIs with this: public void start(Stage primaryStage),
interacting with the mainGUI (see Threads.java),
check list to see if name is in it, if not, then add it to the ListView (threadList1)
*/


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import java.util.Observable;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Boldness extends Application {
    Thread thread;

    @Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 600, 600);
		primaryStage.setScene(scene);

		ArrayList<String> classNames = new ArrayList<String>();
		classNames.add("Help");



		primaryStage.setTitle("Glory");



		Label userName = new Label("Enter Runnable: ");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);


		ListView<String> threadList1 = new ListView<String>();
		ObservableList<String> items1 = FXCollections.observableArrayList (classNames);
		threadList1.setItems(items1);

		ListView<String> threadList2 = new ListView<String>();
		ObservableList<String> items2 = FXCollections.observableArrayList ();
		threadList2.setItems(items2);

		// adds the threadLists to the grid
		grid.add(threadList1, 0, 2);
		grid.add(threadList2, 1, 2);



		Button btn1 = new Button();
		btn1.setText("Start");
 
      btn1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
			public void handle(ActionEvent event) {

				String runnableName = threadList1.getSelectionModel().getSelectedItem();
				try {
					Runnable r = (Runnable)Class.forName(runnableName).newInstance();
					thread = new Thread(r);
					thread.start();
					thread.setName(runnableName + "-->" + thread.getName());
					threadList2.getItems().add(thread.getName());
				} catch (Exception e) {
					System.out.println("Runnable Error. Details: " + e.getMessage());
         		e.printStackTrace();
				}
         }
	   });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn1);

		grid.add(btn1, 0, 4);


		Button btn2 = new Button();
		btn2.setText("Stop and Remove");
 
      btn2.setOnAction(new EventHandler<ActionEvent>() {
	      @Override	
			public void handle(ActionEvent event) {
				System.out.println("You just killed the thread: " + thread.getName());
//				thread.getName().terminate();
//				thread.join();
      	}
	   });
        
      StackPane root1 = new StackPane();
      root1.getChildren().add(btn2);


		grid.add(btn2, 1, 4);



		userTextField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Get the text of the box
				String runnableName = userTextField.getText();
				
				try {
					// I just need to check to see if it's a class
					// It will throw an exception if it isn't a class
					Class.forName(runnableName).newInstance();
				
					// if it doesn't exist, 
					// the exception will throw before it reaches these lines below

					// put the text into the list
					threadList1.getItems().add(runnableName);
					
					// clears the text field
					userTextField.clear();
				} catch (Exception e) {
					System.out.println("Runnable Error. Details: " + e.getMessage());
         		e.printStackTrace();
				}
			}


		});


	   primaryStage.setScene(scene);
	   primaryStage.show();

/*
		try {
	   	Class.forName(runnableName).newInstance();
	   } catch (Exception e) {
         System.out.println("Error. Details: " + e.getMessage());
         e.printStackTrace();
      }

		Class runnable = Class.forName(name);
		boolean isReallyRunnable = Runnable.class.isAssignableFrom(runnable);

		if (isReallyRunnable)
		{
			Runnable runnable = (Runnable) Class.forName(runnableName).newInstance();
		}
	*/	
   }
  /* 
	private static void CopySelectedItems(ListView source, 
													  ListView target)
	{
		int index = source.getSelectedIndex();
	   target.getItems().add(index);
	}
*/
   public static void main(String[] args) {
       launch(args);
   }
}

/*
Platform.runLater(new Runnable() {
	@Override
	public void run() {
		stage.setTitle(newTitle);
	}
});
*/