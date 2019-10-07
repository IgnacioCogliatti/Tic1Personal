package com.LabMovix.Movix.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Controller {
    public static String urlserver = "http://192.168.43.108:8080";

    @FXML
    private AnchorPane pan2;
    @FXML
    private AnchorPane pan1;
    @FXML
    private AnchorPane pan3;
    @FXML
    private ScrollPane pan4;
    @FXML
    private AnchorPane pan5;
    @FXML
    private AnchorPane panbarra;
    @FXML
    private AnchorPane panbarra1;
    @FXML
    private AnchorPane infoview;

    @FXML
    private RadioButton dosdPelicula;
    @FXML
    private RadioButton tresdpelicula;
    @FXML
    private RadioButton cuatrodPelicula;

    @FXML
    private TextArea infoPelicula;
    @FXML
    private TextArea descripcionPelicula;

    @FXML
    private DatePicker estrenoPelicula;
    @FXML
    private DatePicker limitePelicula;

    @FXML
    private TextField tituloPelicula;
    @FXML
    private MenuButton generoPelicula;
    @FXML
    private TextField actoresPelicula;
    @FXML
    private TextField directorPelicula;
    @FXML
    private TextField edadminPelicula;
    @FXML
    private TextField duracionPelicula;

    @FXML
    private TextArea pantallaPeliculas;

    @FXML
    private ImageView menub;
    @FXML
    private ImageView peliculab;
    @FXML
    private ImageView salab;
    @FXML
    private ImageView peliculasCreadasb;

    public void Iniciar(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(true);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan5.setVisible(false);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        peliculasCreadasb.setVisible(true);
        infoview.setVisible(false);
    }

    public void crearPelicula(MouseEvent evento) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pelicula Creada");
        alert.setHeaderText("Pelicula Creada!");
        alert.setContentText("click en 'aceptar' para crar otra pelicula ");
        alert.showAndWait();
        RestTemplate restTemplate = new RestTemplate();
        try {
            Quote quote = restTemplate.getForObject(urlserver + "/upload/movie?movieName=" + tituloPelicula.getText()/*+"&movieId="+idPelicula.getText()+"&movieDuracion="+duracionPelicula.getText()+"&movieGenero="+generoPelicula.getItems()+"&movieEdadMin="+edadminPelicula.getText()+"&movieActores="+actoresPelicula.getText()+"&movieDirector="+directorPelicula.getText()+"&2D="+dosdPelicula.isCache()+"&3D="+tresdPelicula.isCache()+"&4D="+cuatrodPelicula.isCache()+"&movieLimite="+limitePelicula.getEditor()+"&movieEstreno="+estrenoPelicula.getEditor()+"&movieInfo="+infoPelicula.getText()+"&movieDescripcion="+descripcionPelicula.getText()*/, Quote.class);
        } catch (Exception e) {
        }
    }

    public void Pelicula(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan2.setVisible(true);
        pan3.setVisible(false);
        pan5.setVisible(false);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        menub.setVisible(true);
        peliculasCreadasb.setVisible(true);
    }

    public void Sala(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(true);
        pan5.setVisible(false);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        peliculasCreadasb.setVisible(true);

    }

    public void MenuAgrandado(MouseEvent evento) {

        panbarra.setVisible(true);
        panbarra1.setVisible(true);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        peliculasCreadasb.setVisible(true);

    }

    public void mostarInfo(MouseEvent evento){
        infoview.setVisible(true);
    }
    public void Creadas(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan5.setVisible(true);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        peliculasCreadasb.setVisible(true);
    }

    public void listarPeliculas(MouseEvent evento) {
        RestTemplate restTemplate = new RestTemplate();
        try {
//            Quote[] quote = restTemplate.getForObject(urlserver + "/list/movie?limit=20", Quote[].class);
//            System.out.println("Quote: " + quote.toString());
            String pantallaText = "";
//            for (Quote q : quote) {
//                pantallaText += q.toString();
//            }
           ResponseEntity<List<Movie>> rateResponse = restTemplate.exchange(urlserver + "/list/movie?limit=22", HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
          }) ;
           List<Movie> movies = rateResponse.getBody();
           for (Movie movie : movies){
               pantallaText += movie.getTitle() + "\n";
           }
            pantallaPeliculas.setText(pantallaText);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}