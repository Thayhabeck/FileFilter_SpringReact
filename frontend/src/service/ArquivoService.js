import axios from "axios";

const ARQUIVO_URL = "http://localhost:8080/arquivos";

class ArquivoService {
    getAllFiles() {
        return axios.get(ARQUIVO_URL + "/listarTodos");
    }

    getByName(nome) {
        return axios.get(ARQUIVO_URL + "/listarNome?nome=" + nome);
    }

    getAllByType(tipo) {
        return axios.get(ARQUIVO_URL + "/listarTipo?tipo=" + tipo);
    }

    getAllByDate(dtInicial, dtFinal) {
        return axios.get(ARQUIVO_URL + "/listarData?dataFinal=" + dtFinal + "&dataInicial=" + dtInicial);
    }
}

export default new ArquivoService();