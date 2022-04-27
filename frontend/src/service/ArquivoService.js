import axios from "axios";

const ARQUIVO_URL = "https://thabeck-filter.herokuapp.com/arquivos";

class ArquivoService {
    getAllFiles() {
        return axios.get(ARQUIVO_URL + "/listarTodos");
    }

    getByName(nome) {
        return axios.get(ARQUIVO_URL + "/listarNome?Nome=" + nome);
    }

    getAllByType(tipo) {
        return axios.get(ARQUIVO_URL + "/listarTipo?Tipo=" + tipo);
    }

    getAllByDate(dtInicial, dtFinal) {
        return axios.get(ARQUIVO_URL + "/listarData?DataFinal(dd/mm/aaaa)=" + dtFinal + "&DataInicial(dd/mm/aaaa)=" + dtInicial);
    }
}

export default new ArquivoService();