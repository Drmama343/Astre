package fr.elpine.astre.ihm;

import fr.elpine.astre.Controleur;
import fr.elpine.astre.ihm.stage.Manager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AstreApplication extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		Logger logger = LoggerFactory.getLogger(getClass());

		/* STYLE
		* Thèmes    : cupertino & dracula
		* Variantes : dark & light
		* */

		Application.setUserAgentStylesheet(Objects.requireNonNull(AstreApplication.class.getResource("styles/cupertino-light.css")).toExternalForm());


		if ( !Controleur.get().getDb().reloadDB() ) {
			logger.warn("Informations de connexion à la base de données erronées, nouvelle saisie demandé !");

			Stage stage = Manager.creer( "initDb" );
			stage.show();
		} else {
			Stage stage = Manager.creer( "accueil" );
			stage.show();
		}
	}

	public static void refreshIcon(Stage stage)
	{
		stage.getIcons().add(new Image(Objects.requireNonNull(AstreApplication.class.getResourceAsStream("icon.png"))));
	}
}
