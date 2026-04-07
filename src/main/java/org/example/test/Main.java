package org.example.test;

import org.example.entities.Blog;
import org.example.services.ServiceBlog;
import org.example.utils.MyDatabase;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyDatabase db = MyDatabase.getInstance();

        // Test connexion

        ServiceBlog service = new ServiceBlog();

        // ✅ CREATE
        Blog b1 = new Blog("Blog 1", "Contenu 1", "Gaming", "img1.png");
        service.ajouter(b1);

        // ✅ READ
        System.out.println("\n--- LISTE BLOGS ---");
        List<Blog> blogs = service.afficher();
        for (Blog b : blogs) {
            System.out.println(b);
        }

        // ✅ UPDATE (mettre un id existant)
        Blog b2 = new Blog(1, "Blog modifié", "Nouveau contenu", null, "Tech", "img2.png", 0);
        service.modifier(b2);

        // ✅ DELETE (mettre un id existant)
        service.supprimer(1);

        // ✅ READ FINAL
        System.out.println("\n--- LISTE APRÈS MODIF ---");
        service.afficher().forEach(System.out::println);
    }
        /*ServiceTest st = new ServiceTest();
        test t = new test("ghaith");

        try {
            // ajouter
            st.ajouter(t);
            System.out.println("Ajout termine");

            // get all
            List<test> listeAvant = st.getAll();
            System.out.println("Liste: " + listeAvant);

            if (!listeAvant.isEmpty()) {
                test premier = listeAvant.get(0);

                // modifier
                premier.setName("rajhi");
                st.modifier(premier);
                System.out.println("Modification terminee");
                System.out.println("Liste modifie: " + st.getAll());

                // supprimer
                st.supprimer(premier.getId());
                System.out.println("Suppression terminee");
                

                // get all apres suppression
                System.out.println("Liste finale: " + st.getAll());
            } else {
                System.out.println("Aucune donnee dans la table test.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */




        }