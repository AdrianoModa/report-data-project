import { Loja } from './loja';

export class Venda {

    id: number
    nomeLoja: string
    data: string
    valor: number
    dia: number
    mes: number
    ano: number
    lojas: Loja = new Loja()

}
