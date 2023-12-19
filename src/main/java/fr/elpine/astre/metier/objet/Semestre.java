package fr.elpine.astre.metier.objet;

import java.util.ArrayList;

public class Semestre
{
    private int numero   ;
    private int nbGrpTD  ;
    private int nbGrpTP  ;
    private int nbEtd    ;
    private int nbSemaine;

    private Annee annee;
    private ArrayList<Module> ensModule;


    public Semestre(int numero, int nbGrpTD, int nbGrpTP, int nbEtd, int nbSemaine, Annee annee)
    {
        this.numero    = numero;
        this.nbGrpTD   = nbGrpTD;
        this.nbGrpTP   = nbGrpTP;
        this.nbEtd     = nbEtd;
        this.nbSemaine = nbSemaine;
        this.annee     = annee;

        this.ensModule = new ArrayList<>();
    }


    /* GETTER */

    public int   getNumero    () { return numero;    }
    public int   getNbGrpTD   () { return nbGrpTD;   }
    public int   getNbGrpTP   () { return nbGrpTP;   }
    public int   getNbEtd     () { return nbEtd;     }
    public int   getNbSemaine () { return nbSemaine; }
    public Annee getAnnee     () { return annee;     }

    /* SETTER */

    public void setNumero    ( int numero    ) { this.numero    = numero;    }
    public void setNbGrpTD   ( int nbGrpTD   ) { this.nbGrpTD   = nbGrpTD;   }
    public void setNbGrpTP   ( int nbGrpTP   ) { this.nbGrpTP   = nbGrpTP;   }
    public void setNbEtd     ( int nbEtd     ) { this.nbEtd     = nbEtd;     }
    public void setNbSemaine ( int nbSemaine ) { this.nbSemaine = nbSemaine; }

    public void setAnnee( Annee annee )
    {
        if ( annee != null )
            annee.ajouterSemestre(this);
        else if ( this.annee != null )
            this.annee.supprimerSemestre(this);

        this.annee = annee;
    }


    public void ajouterModule(Module module)
    {
        if (module != null && !this.ensModule.contains(module))
        {
            this.ensModule.add(module);

            module.setSemestre(this);
        }
    }

    public void supprimerModule(Module module)
    {
        if (module == null || !this.ensModule.contains(module)) return;

        this.ensModule.remove(module);

        module.setSemestre(null);
    }

    public ArrayList<Module> getModules() { return this.ensModule; }
}
