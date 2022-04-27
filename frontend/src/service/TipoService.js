import axios from "axios";

const TIPO_URL = "http://localhost:8080/tipos";

class TipoService {
    getAllTypes() {
        return axios.get(TIPO_URL);
    }
}

export default new TipoService();