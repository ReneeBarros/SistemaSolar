package br.com.dasare.solarOffGrid.domain.offgrid.irradiacao_solar

import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar
import br.com.dasare.solarOffGrid.entity.IrradiacaoSolar
import kotlin.math.abs

class  BuscarIrradicaoSolar {


    fun encontrarlongitudeMaisProxima(
        valorEntrada: Double,
        tabela: List<IrradiacaoSolar>
    ): IrradiacaoSolar{

        var irradiacaoSolar = tabela[0]
        var valorMaisProximo = tabela[0].longitude
        var menorDiferenca = abs(valorEntrada -valorMaisProximo )

        for (valor in tabela) {
            val diferencaAtual = abs(valorEntrada - valor.longitude)

            if (diferencaAtual < menorDiferenca) {
                menorDiferenca = diferencaAtual
                valorMaisProximo = valor.longitude
                irradiacaoSolar = valor
            }
        }
        return irradiacaoSolar
    }


    fun encontrarCoordenadaMaisProxima(
        tabela: List<IrradiacaoSolar>,
        valorEntradaLatitude: Double,
        valorEntradaLongitude: Double
    ): IrradiacaoSolar? {
        if (tabela.isEmpty()) return null // Retorna nulo se a tabela estiver vazia

        var irradiacaoMaisProxima = tabela[0]
        var menorDiferenca = Double.MAX_VALUE

        for (coordenada in tabela) {
            val diferencaAtual = (valorEntradaLongitude - coordenada.longitude).let { diffLongitude ->
                val diffLatitude = valorEntradaLatitude - coordenada.latitude
                diffLongitude * diffLongitude + diffLatitude * diffLatitude
            }

            if (diferencaAtual < menorDiferenca) {
                menorDiferenca = diferencaAtual
                irradiacaoMaisProxima = coordenada
            }
        }

        return irradiacaoMaisProxima
    }

    fun encontrarMenorIrradiacao(irradiacaoSolar: ResponseIrradiacaoSolar):Double{

        var irradiacoes = listOf(
            irradiacaoSolar.janeiro,
            irradiacaoSolar.fervereiro,
            irradiacaoSolar.marco,
            irradiacaoSolar.abril,
            irradiacaoSolar.maio,
            irradiacaoSolar.junho,
            irradiacaoSolar.julho,
            irradiacaoSolar.agosto,
            irradiacaoSolar.setembro,
            irradiacaoSolar.outubro,
            irradiacaoSolar.novembro,
            irradiacaoSolar.dezembro
        )
        var menorIrradiacao = irradiacoes[0]
        irradiacoes.forEach { d ->
            if (menorIrradiacao < d ){
                menorIrradiacao = d
            }
        }

        return menorIrradiacao
    }


}