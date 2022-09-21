import { Dettaglio } from "./Dettaglio";

export interface DettagliListResponse{
    dettagli: Array<Dettaglio>;
    totale: number;
}