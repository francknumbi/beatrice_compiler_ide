/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AInferieurConditionSimple extends PConditionSimple
{
    private PExpress _gauche_;
    private TOperateurInferieur _operateurInferieur_;
    private PExpress _droite_;

    public AInferieurConditionSimple()
    {
        // Constructor
    }

    public AInferieurConditionSimple(
        @SuppressWarnings("hiding") PExpress _gauche_,
        @SuppressWarnings("hiding") TOperateurInferieur _operateurInferieur_,
        @SuppressWarnings("hiding") PExpress _droite_)
    {
        // Constructor
        setGauche(_gauche_);

        setOperateurInferieur(_operateurInferieur_);

        setDroite(_droite_);

    }

    @Override
    public Object clone()
    {
        return new AInferieurConditionSimple(
            cloneNode(this._gauche_),
            cloneNode(this._operateurInferieur_),
            cloneNode(this._droite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInferieurConditionSimple(this);
    }

    public PExpress getGauche()
    {
        return this._gauche_;
    }

    public void setGauche(PExpress node)
    {
        if(this._gauche_ != null)
        {
            this._gauche_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gauche_ = node;
    }

    public TOperateurInferieur getOperateurInferieur()
    {
        return this._operateurInferieur_;
    }

    public void setOperateurInferieur(TOperateurInferieur node)
    {
        if(this._operateurInferieur_ != null)
        {
            this._operateurInferieur_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurInferieur_ = node;
    }

    public PExpress getDroite()
    {
        return this._droite_;
    }

    public void setDroite(PExpress node)
    {
        if(this._droite_ != null)
        {
            this._droite_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._droite_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._gauche_)
            + toString(this._operateurInferieur_)
            + toString(this._droite_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._gauche_ == child)
        {
            this._gauche_ = null;
            return;
        }

        if(this._operateurInferieur_ == child)
        {
            this._operateurInferieur_ = null;
            return;
        }

        if(this._droite_ == child)
        {
            this._droite_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._gauche_ == oldChild)
        {
            setGauche((PExpress) newChild);
            return;
        }

        if(this._operateurInferieur_ == oldChild)
        {
            setOperateurInferieur((TOperateurInferieur) newChild);
            return;
        }

        if(this._droite_ == oldChild)
        {
            setDroite((PExpress) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}