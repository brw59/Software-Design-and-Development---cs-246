import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BoldnessExample extends Application {

	private ListView <String> runnablesList;
	private ListView <String> runningThreads;
	private TextField entry;

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Threads of Glory");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

		grid.setPadding(new Insets(25, 25, 25, 25));

		// runnables label
		Label runnableLabel = new Label("Runnables");
		grid.add(runnableLabel, 0, 1);
		//runnables list
		runnablesList = new ListView<String>();
		grid.add(runnablesList, 0, 2, 2, 4);
		GridPane.setMargin(runnablesList ,new Insets(10,10,0,0));

		//running threads label
		Label runningThreadsLabel = new Label("Running Threads");
		grid.add(runningThreadsLabel, 4, 1);
		//running threads list
		runningThreads = new ListView<String>();
		grid.add(runningThreads, 4, 2, 2, 4);
		GridPane.setMargin(runningThreads ,new Insets(10,10,0,0));

		// 'enter runnable' label
		Label enterRunnable = new Label("Enter Runnable");
		grid.add(enterRunnable, 0, 0);
		// runnable text box
		entry = new TextField();
		grid.add(entry, 1, 0);
		// add button
		Button addBtn = new Button(" Add ");
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		String input = entry.getText();
        		try {
        			Runnable r = (Runnable)Class.forName(input).newInstance();
        			runnablesList.getItems().add(input);
        		} catch (Exception ex) {
        			System.out.println("Not a Runnable");
        		}
        	}
        });
		grid.add(addBtn, 2, 0);


		// start button
		Button start = new Button("Start Thread");
		start.setOnAction(new EventHandler<ActionEvent>() { 

			@Override
			public void handle(ActionEvent e) {
				String str = runnablesList.getSelectionModel().getSelectedItem();
				try {
					Runnable run = (Runnable)Class.forName(str).newInstance();
					Thread thr = new Thread(run);
					thr.start();
					thr.setName(str + "_" + thr.getName());
					runningThreads.getItems().add(thr.getName());
				} catch (Exception ex) {
					System.out.println("Error starting runnable \'" + str + "\'");
				}
			}
		});
		grid.add(start, 0, 9);

		//stop button
		Button stop = new Button("Stop Thread");
		stop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("you pressed the stop button!");
			}
		});
		grid.add(stop, 4, 9);


		// this should be last, it sets the scene after you build it
		Scene scene = new Scene(grid, 650, 400);
		primaryStage.setScene(scene);   
		primaryStage.show();
	}

}