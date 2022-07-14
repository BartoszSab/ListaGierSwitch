package com.listagier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;


public class Main extends JFrame {

    // tak zwana szybka główna
    public Main() throws URISyntaxException {

        super("Lista Gier Switch");

        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(szer / 2, 800);
        this.setJMenuBar(pasekMenu);


        // uniwersalny kod do wycentrowania aplikacji na ekranie
        int sizeWidthBorder = this.getSize().width;
        int sizeHeightBorder = this.getSize().height;
        this.setLocation((szer - sizeWidthBorder) / 2, (wys - sizeHeightBorder) / 2);

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        JMenuItem podmenuNowy = menuPlik.add("Nowy");
        menuPlik.addSeparator();
        JMenuItem podmenuOpen = menuPlik.add("Otworz");
        JMenuItem podmenuSave = menuPlik.add("Zapisz");
        JMenuItem podmenuDelete = menuPlik.add("Usuń");
        menuPlik.addSeparator();
        JMenuItem podmenuExit = menuPlik.add("Wyjście");

        podmenuNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tworzy się nowy plik");
            }
        });
        podmenuOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Otwiera się zapisany plik");
            }
        });
        podmenuSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zapisuje się plik");
            }
        });
        podmenuDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Usuwamy plik");
            }
        });
        podmenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);

            }
        });


        JMenu menuEdit = pasekMenu.add(new JMenu("Edytuj"));
        JMenuItem podmenuAdd = menuEdit.add("Dodaj nową grę");
        JMenuItem podmenuItem = menuEdit.add("Usuń grę");
        JMenuItem podmenuEdit = menuEdit.add("Edytuj rekord");

        podmenuAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dodaję");
            }
        });
        podmenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kasuję rekord");
            }
        });
        podmenuEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edytuję");
            }
        });

        JMenu menuSettings = pasekMenu.add(new JMenu("Ustawienia"));
        JMenuItem podmenuFont =menuSettings.add("Czcionka");
        JMenuItem podmenuBigText =menuSettings.add("Powiększ tekst");
        JMenuItem podmenuSmallText =menuSettings.add("Zmniejsz tekst");
        JMenuItem podmenuBackground =menuSettings.add("Zmień Tło");

        podmenuFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zmieniam czcionkę");
            }
        });
        podmenuBigText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Powiększam tekst");
            }
        });
        podmenuSmallText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zmniejszam tekst");
            }
        });
        podmenuBackground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zmieniam tło");
            }
        });

        JMenu menuHelp = pasekMenu.add(new JMenu("Pomoc"));
        JMenuItem podmenuHelpMe =menuHelp.add("Pomoc");
        menuHelp.addSeparator();
        JMenuItem podmenuInstructions =menuHelp.add("Instrukcja");
        JMenuItem podmenuInformation =menuHelp.add("Informacje o wersji");

        podmenuHelpMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pomoc");
            }
        });
        podmenuInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Instrukcje dodawania gier");
            }
        });
        podmenuInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Informacje o wersji");
            }
        });



        initComponents();


        this.getContentPane().add(listaGier, BorderLayout.CENTER);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("main icon.png"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

    }



    // metoda do inicjalizacji komponentów
    public void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());

        this.getContentPane().setLayout(layout);


        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        addToFile.addActionListener(new dodajDoPliku());
        gameList.addActionListener(new openTheGameList());
        exitOnClick.addActionListener(new exitAndClose());



        layout.setVerticalGroup(
                layout.createSequentialGroup()

                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(addToFile)
                                        .addComponent(gameList)
                                        .addComponent(exitOnClick)
                )
                         .addComponent(listaGier, 100, 800, 1000)

        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(addToFile)
                                        .addComponent(gameList)
                                        .addComponent(exitOnClick)
                        )
                        .addComponent(listaGier, 100, 800, 1000)
                        );
    }

    JButton addToFile = new JButton("Dodaj do pliku");
    JButton gameList = new JButton("Lista Gier Switch");
    JButton exitOnClick = new JButton("Zamknij program");




    private JTextArea listaGier = new JTextArea("Gra 1 Gra 2", 20, 100);
    private  JMenuBar pasekMenu = new JMenuBar();


    private class dodajDoPliku implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Otwieram menu");
        }
    }

    private class openTheGameList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            final URI uri;
            try {
                uri = new URI("https://www.dekudeals.com/");
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(uri);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }




    private class exitAndClose implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args)  {
        PrintWriter doZapisywaniaPlikow = null;
        try {
            doZapisywaniaPlikow = new PrintWriter(new FileWriter("dane.txt"));
            doZapisywaniaPlikow.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Main().setVisible(true);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}



/*Adnotations
1. Żeby coś stworzyć trzeba uzupełnić danew trzech miejscach. Stworzyć przycisk.
Dodać go do komponentów, a następnie uwidocznić go w szybce (Main).
2. Komponenty dodaje się do szybki za pomocą czyli initComponents(); kontenera.
Ważne, żeby był poza klasą Main.
Metoda Container kontener = this.getContentPane(); zostaje dodana do komponentów,
a następnie do kontenera dodajemy .add(nazwa)

 */

