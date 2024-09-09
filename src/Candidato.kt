class Candidato(val nombre: String, val partido: String) {
    val votos: Int = 0
    var votosInternet: Int = 0
    var votosRadio: Int = 0
    var votosTelevision: Int = 0

    constructor(nombre: String, partido: String, votosInternet: Int, votosRadio: Int, votosTelevision: Int) : this(nombre, partido) {
        this.votosInternet = votosInternet
        this.votosRadio = votosRadio
        this.votosTelevision = votosTelevision
    }

    fun calcularCostoCampana(): Int {
        return (votosInternet * 700000) + (votosRadio * 200000) + (votosTelevision * 600000)
    }

    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTelevision
    }

    fun totalVotosPorCandidato(candidato: String, votos: Map<String, Int>): Int {
        return votos.getOrDefault(candidato, 0)
    }

    fun costoPromedioPorVoto(): Double {
        val totalVotos = totalVotos()
        val costoTotal = calcularCostoCampana()
        return if (totalVotos > 0) costoTotal.toDouble() / totalVotos.toDouble() else 0.0
    }


}

