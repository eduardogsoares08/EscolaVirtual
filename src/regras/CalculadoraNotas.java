package regras;

public class CalculadoraNotas {

    public double calcularMedia(double notaTrabalho, double notaProva) {
        validarNota(notaTrabalho);
        validarNota(notaProva);

        double media = (notaTrabalho * 0.4) + (notaProva * 0.6);
        return Math.round(media * 100.0) / 100.0;
    }

    public boolean aprovado(double media, int faltas, int cargaHoraria) {
        if (cargaHoraria <= 0) throw new IllegalArgumentException("cargaHoraria inválida");
        if (faltas < 0) throw new IllegalArgumentException("faltas negativas");

        double limiteFaltas = Math.floor(cargaHoraria * 0.25);
        boolean criterioNota = media >= 6.0;
        boolean criterioFrequencia = faltas <= limiteFaltas;

        return criterioNota && criterioFrequencia;
    }

    private void validarNota(double n) {
        if (n < 0.0 || n > 10.0)
            throw new IllegalArgumentException("nota fora do intervalo 0..10");
    }
}
