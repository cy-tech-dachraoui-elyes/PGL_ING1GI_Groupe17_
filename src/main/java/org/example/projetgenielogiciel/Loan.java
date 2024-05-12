package org.example.projetgenielogiciel;

import java.util.Calendar;
import java.util.Date;

public class Loan
{
    private int id;
    private long isbn;
    private Date dateLoan;
    private Date plannedDateBack;
    private Date effectiveDateBack;
    private boolean late;
    private boolean returned;

    public Loan(long isbn)
    {
        this.isbn = isbn;
        this.dateLoan = new Date();
        this.plannedDateBack = calculateScheduledReturnDate();
        this .effectiveDateBack = null;
        this.late = false;
    }

    public int getId()
    {
        return id;
    }
    public long getIsbn()
    {
        return isbn;
    }

    public Date getDateLoan()
    {
        return dateLoan;
    }

    public Date getPlannedDateBack()
    {
        return plannedDateBack;
    }

    public Date getEffectiveDateBack()
    {
        return effectiveDateBack;
    }

    public boolean isLate()
    {
        return late;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setIsbn(long isbn)
    {
        this.isbn = isbn;
    }

    public void setDateLoan(Date dateLoan)
    {
        this.dateLoan = dateLoan;
    }

    public void setPlannedDateBack(Date plannedDateBack)
    {
        this.plannedDateBack = plannedDateBack;
    }

    public void setEffectiveDateBack(Date effectiveDateBack)
    {
        this.effectiveDateBack = effectiveDateBack;
    }

    public void setLate(boolean late)
    {
        this.late = late;
    }

    private Date calculateScheduledReturnDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateLoan);
        calendar.add(Calendar.DAY_OF_MONTH,14);
        return calendar.getTime();
    }

    public void markBack()
    {
        this.effectiveDateBack = new Date();
        this.late = calculateLate();
        this.returned = true;
    }

    private boolean calculateLate()
    {
        return (effectiveDateBack != null && effectiveDateBack.after(plannedDateBack));
    }

    @Override
    public String toString()
    {
        return "Loan{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", dateLoan=" + dateLoan +
                ", plannedBackDate=" + plannedDateBack +
                ", effectiveBackDate=" + effectiveDateBack +
                ", late=" + late +
                ", returned=" + returned +
                '}';
    }
}
