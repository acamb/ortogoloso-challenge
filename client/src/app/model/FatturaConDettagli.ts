import { Dettaglio } from "./Dettaglio";
import { Fattura } from "./Fattura";

export interface FatturaConDettagli{
    fattura: Fattura,
    dettagli: Array<Dettaglio>
}