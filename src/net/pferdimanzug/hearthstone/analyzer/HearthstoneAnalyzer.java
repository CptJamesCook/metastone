package net.pferdimanzug.hearthstone.analyzer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.pferdimanzug.hearthstone.analyzer.gui.IconFactory;

public class HearthstoneAnalyzer extends Application {

	public static void main(String[] args) {
		// DevCheckCardCompleteness.updateCardCatalogue();
		// DevCheckCardCompleteness.writeImplementedCardsToFile("implemented_cards.csv");
		launch(args);

		// DevCheckCardCompleteness.assignUniqueIdToEachCard();
		// new HearthstoneAnalyzer().launchDebugGame();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MetaStone");
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.setResizable(false);

		ApplicationFacade facade = (ApplicationFacade) ApplicationFacade.getInstance();
		final HearthstoneAnalyzer instance = new HearthstoneAnalyzer();
		facade.startUp(instance);

		StackPane root = new StackPane();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(IconFactory.class.getResource("main.css").toExternalForm());
		primaryStage.setScene(scene);
		facade.sendNotification(GameNotification.CANVAS_CREATED, root);
		facade.sendNotification(GameNotification.MAIN_MENU);
		primaryStage.show();
	}

}
