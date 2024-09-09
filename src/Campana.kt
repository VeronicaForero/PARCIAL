class Campana {
        private val nombre: String
        private val candidato: Candidato

        constructor(nombre: String, candidato: Candidato) {
            this.nombre = nombre
            this.candidato = candidato
        }

        fun calcularCostoPromedio(totalVotos: Int): Double {
            return if (totalVotos > 0) {
                candidato.calcularCostoCampana().toDouble() / totalVotos.toDouble()
            } else {
                0.0
            }
        }



}


