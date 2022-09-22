export enum ModalitaPagamento{
    BONIFICO="BONIFICO",
    SDD="SDD"
}

export class Fattura{
    id: number;
    identificativo: string;
    dataEmissione: Date;
    nomePrestatore: string = "Ortogoloso";
    partitaIvaPrestatore: string = "12345678911";
    nomeCessionario: string;
    partitaIvaCessionario: string;
    modalitaPagamento: ModalitaPagamento = ModalitaPagamento.BONIFICO;
    importo: number;
    iban: string;
    numeroRate: number = 1;  
}