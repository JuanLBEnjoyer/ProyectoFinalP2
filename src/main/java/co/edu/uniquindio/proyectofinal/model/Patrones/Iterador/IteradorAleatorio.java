package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class IteradorAleatorio<T> implements Iterator<T> {
    private final Collection<T> elementos;
    private final Random random;
    private int indice;

    public IteradorAleatorio(Collection<T> elementos) {
        this.elementos = elementos;
        this.random = new Random();
        this.indice = random.nextInt(elementos.size());
    }

    @Override
    public boolean hasNext() {
        return !elementos.isEmpty();
    }

    @Override
    public T next() {
        T elemento = elementos.stream().skip(indice).findFirst().orElseThrow();
        indice = random.nextInt(elementos.size());
        return elemento;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada.");
    }
}

