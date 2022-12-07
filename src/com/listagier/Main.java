package com.listagier;

/**
 * @Author Bartosz Sabała Angelus
 * @ Ver. 1.0.5
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
        JMenuItem podmenuHelpMe = menuHelp.add("Pomoc");
        menuHelp.addSeparator();
        JMenuItem podmenuInstructions = menuHelp.add("Instrukcja");
        JMenuItem podmenuInformation = menuHelp.add("Informacje o wersji");

        podmenuHelpMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pomoc");
                JOptionPane.showMessageDialog(null, "<html><u>Pomoc</u></html>", "Help", JOptionPane.PLAIN_MESSAGE);

            }
        });
        podmenuInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "<html><u>Miejscę na instrukcję dodawania gier w Aplikacji.</u></html>", "Instruction", JOptionPane.PLAIN_MESSAGE);
            }
        });
        podmenuInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Informacje o wersji");
                JOptionPane.showMessageDialog(null, "<html><u>Informacje o wersji.</u></html>", "Version", JOptionPane.PLAIN_MESSAGE);
            }
        });

        initComponents();

        this.getContentPane().add(listaGier, BorderLayout.CENTER);
        this.add(primaryPhoto);
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

        addToFile.addActionListener(new dodajMiejsceDoPliku());
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
                        .addComponent(jT)
                         .addComponent(listaGier, 100, 500, 600)
                         .addComponent(primaryPhoto)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(addToFile)
                                        .addComponent(gameList)
                                        .addComponent(exitOnClick)
                        )
                        .addComponent(jT, 1000, 1000, 1000)
                        .addComponent(listaGier, 100, 800, 1000)
                        .addComponent(primaryPhoto)
                        );
    }

    JButton addToFile = new JButton("Dodaj do pliku");
    JButton gameList = new JButton("Lista Gier Switch");
    JButton exitOnClick = new JButton("Zamknij program");


    private JTextArea listaGier = new JTextArea("Miejsce na notatki: ", 10, 60);
    private  JMenuBar pasekMenu = new JMenuBar();
    private PrimaryPhoto primaryPhoto = new PrimaryPhoto();



    String columns[] ={"number", "gameName", "physicalOfDigital", "finished", "price"};
    String games[][] = {
            {"Number", "Game Name", "Physical Or Digital", "Finished", "Price"},
            {"1","Fifa 2020", "physical", "yes", "100"},
            {"2","Wiedźmin 3 Complete Edition", "physical", "yes", "230"},
            {"3","Pokemon Sword & expansion pack", "physical", "yes", "350"},
            {"4","Call of Cthulhu", "physical", "yes", "0"},
            {"5","Ys VIII  Lacrimosa of Dana", "physical", "yes", "0"},
            {"6","Xenoblade Chronicles Definite Edition", "physical", "no", "0"},
            {"7","The Legend of Zelda Breath of the Wild", "physical", "no", "230"},
            {"8", "8.Diablo III: Eternal Collection", "physical", "yes", "149"},
            {"9", "Final Fantasy X/X2 remastered", "physical", "no", "189"},
            {"10", "Amazing Ring Fit", "physical", "no", "249"},
            {"11", "Astral Chain", "physical", "yes", "0"},
            {"12", "Dragon Quest XI: Echoes", "physical", "yes", "0"},
            {"13", "Divinity Orginal Sin 2", "digital", "yes", "160"},
            {"14", "God Eater 3", "digital", "yes", "140"},
            {"15", "Vampyr", "physical", "yes", "0"},
            {"16", "Call of Cthulhu", "physical", "yes", "80"},
            {"17", "Tokyo Mirage Sessions", "physical", "no", "900"},
            {"18", "Immortal Fenix Rising", "digital", "yes", "124"},
            {"19", "Ni no Kuni Wrath of the White Witch ", "physical", "no", "34"},
            {"20", "Ghostrunner ", "digital", "no", "34"},
            {"20", "Ys IX: Monstrum Nox", "digital", "no", "124"}
    };


    private JTable jT= new JTable(games, columns);
    JScrollPane pane = new JScrollPane(jT);

    //Dodaje


    private class dodajMiejsceDoPliku implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("WOOW");
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

    class PrimaryPhoto extends JComponent {
        Image img1;

        public PrimaryPhoto() {
            super();
            img1 = new ImageIcon("files\\prph.jpg").getImage();
        }
        public void paintComponent(Graphics g) {
            g.drawImage(img1, 100, 100, null);

            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(img1, 100, 100, 100, 80, this);

        }
    }
    public static void main(String[] args) throws IOException {

        try {
            new Main().setVisible(true);
        } catch (URISyntaxException e) {
            e.printStackTrace();
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

