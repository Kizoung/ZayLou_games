/* Classe principale du Jeu
Représente un jeu complet (créé par un utilisateur)
Permet de regrouper toutes les composantes du jeu (cartes, joueur, niveaux, effets).
*/
class Jeu {
    id: string;
    nom: string;
    description: string;
    niveau: Niveau[];
    joueur: Joueur; // etat du joueur pendant le jeu (doit etre une liste)
  }
  
  /* Représente un niveau jouable du jeu.
  */ 
  class Niveau {
    id: string;
    nom: string;
    grille: Case[]; // Grille 2D
    effetsActifs: Effet[];  //liste d’effets actuellement appliqués
  }
  
  /*Une Case peut contenir un ou plusieurs objets
  et aussi c'est Une cellule de la grille du niveau.
  */
   //Propriete qui vont 
   //Grille contient case et case peut survoler plusieurs autre case , Case est il un Pixel
   //Ou unité d'aire. Une case peut etre une unité du jeu donc case representera tjours meme espace 
  class Case {
    x: number;  // coordonnee (peut mettre en debut et fin comme x.debut et x.fin)
    y: number;
    objets: ObjetJeu[];  // objet sur la case 
    maxObjet : // reflechir a une fonction pour ça
  }

  // Couche pour le 2.5D
  
  /* Représente n’importe quel élément visible/interactif dans la grille
  */ 
  class ObjetJeu {
    id: string;
    type: string; // bloc
    couleur: string;
    largeur: number;
    hauteur: number;
  }
  
  /*Représente le personnage contrôlé par le joueur dans le jeu.
  */ 
  class Joueur {
    position: { x: number, y: number };
    vitesse: number;
    peutSauter: boolean;  // categoriser type de jeu et filtre (genre peut etre lier aux effets et type de jeu , acces au parametre)
    effetsActifs: Effet[];  // Comme beaucoup d'effet tableau 
  }
  
  /*Représente un effet issu d’une carte NFC.
  */ 
  class Effet {
    id: string;
    nom: string;
    type: 'bonus' | 'malus';
    description: string;
    duree: num ; // en sec ou min
    cumulable: boolean;
    maxCumul: number;
    effetSur: 'joueur' | 'niveau' | 'ennemis';
    
    effetCallback: (joueur: Joueur, niveau: Niveau) => void; // A voir 
  } // je pense a utiliser ca pour modifier le comportement du joueur , une fois appeler peut appliquer une action 
  