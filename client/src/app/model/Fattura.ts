enum ModalitaPagamento{
    BONIFICO,
    SDD
}

export class Fattura{
    id: number;
    identificativo: string;
    dataEmissione: Date;
    nomePrestatore: string = "Ortogoloso";
    partitaIvaPrestatore: string = "12345678911";
    nomeCessionario: string;
    partitaIvaCessionario: string;
    modalitaPagamento: ModalitaPagamento;
    importo: number;
    iban: string;
    numeroRate: number = 1;  
}