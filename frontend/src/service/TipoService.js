import axios from "axios";

const TIPO_URL = "https://thabeck-filter.herokuapp.com/tipos";

class TipoService {
    getAllTypes() {
        return axios.get(TIPO_URL);
    }
}

export default new TipoService();