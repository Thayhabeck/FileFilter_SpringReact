import React, { useState, useEffect } from "react";
import ArquivoService from "../service/ArquivoService";
import TipoService from "../service/TipoService";

const HomePage = () => {
    const [nome, setNome] = useState("");
    const [dataIni, setDataIni] = useState("");
    const [dataFin, setDataFin] = useState("");
    const [tipo, setTipo] = useState("");
    const [tipos, setTipos] = useState([]);
    const [arquivos, setArquivos] = useState([]);

    const searchNome = (e) => {
        e.preventDefault();
        if (nome === "")
            alert("Preencha o campo Nome!");
        else
            getByName();
    }
    const searchData = (e) => {
        e.preventDefault();
        if (dataIni === "" || dataFin === "")
            alert("Preencha as duas Datas!");
        else
            getAllByDate();
    }
    const searchTipo = (e) => {
        e.preventDefault();
        if (tipo === "")
            alert("Escolha o Tipo de arquivo!");
        else
            getAllByType();
    }


    const getAllTypes = () => {
        TipoService.getAllTypes()
            .then((response) => {
                setTipos(response.data);
            }).catch((error) => {
                console.log(error);
            });
    };

    const getAllFiles = () => {
        ArquivoService.getAllFiles()
            .then((response) => {
                setArquivos(response.data);
            }).catch((error) => {
                console.log(error);
            });
    };
    const getByName = () => {
        ArquivoService.getByName(nome)
            .then((response) => {
                setArquivos(response.data);
            }).catch((error) => {
                console.log(error);
            });
    };
    const getAllByDate = () => {
        ArquivoService.getAllByDate(dataIni, dataFin)
            .then((response) => {
                setArquivos(response.data);
            }).catch((error) => {
                console.log(error);
            });
    };
    const getAllByType = () => {
        ArquivoService.getAllByType(tipo)
            .then((response) => {
                setArquivos(response.data);
            }).catch((error) => {
                console.log(error);
            });
    };

    useEffect(() => {
        getAllFiles();
    }, []);

    useEffect(() => {
        getAllTypes();
    }, []);

    return (
        <div className="m-2 p-0">
            <form className="container-fluid row p-2 bg-light">
                <div className="col-12 text-lg-start text-light d-inline-flex p-2 bg-primary w-100">
                    <span className="material-icons">
                        search
                    </span>
                    <p className="fw-bold m-0">Filtro de Pesquisa</p>
                </div>
                <div className="col-10 d-inline-flex p-2 bg-gray">
                    <label htmlFor="Nome" className="form-label m-0 py-1 me-3">Nome: </label>
                    <input type="text" className="form-control w-50"
                        id="Nome"
                        placeholder="Nome"
                        value={nome}
                        onChange={(e) => setNome(e.target.value)}
                    />
                </div>
                <div className="col-2 d-inline-flex p-2 bg-gray justify-content-end">
                    <button type="submit" className="btn btn-primary mx-2 d-inline-flex" onClick={(e) => searchNome(e)}>
                        <span className="material-icons">
                            search
                        </span>
                    </button>
                </div>
                <div className="col-5 d-inline-flex p-2">
                    <label htmlFor="DataIni" className="form-label m-0 py-1 me-3">Data Inicial: </label>
                    <input type="text"
                        className="form-control w-50"
                        id="DataIni"
                        placeholder="DD/MM/AAAA"
                        value={dataIni}
                        onChange={(e) => setDataIni(e.target.value)} />
                </div>
                <div className="col-5 d-inline-flex p-2">
                    <label htmlFor="DataFin" className="form-label m-0 py-1 me-3">Data Final: </label>
                    <input type="text" className="form-control w-50"
                        id="DataFin"
                        placeholder="DD/MM/AAAA"
                        value={dataFin}
                        onChange={(e) => setDataFin(e.target.value)} />
                </div>
                <div className="col-2 d-inline-flex p-2 justify-content-end">
                    <button type="submit" className="btn btn-primary mx-2 d-inline-flex" onClick={(e) => searchData(e)}>
                        <span className="material-icons">
                            search
                        </span>
                    </button>
                </div>
                <div className="col-10 d-inline-flex p-2 bg-gray">
                    <label htmlFor="Tipo" className="m-0 py-1 me-3">Tipo: </label>
                    <select className="form-select w-50"
                        aria-label="Tipo"
                        onChange={(e) => setTipo((e.target.value))}>
                        <option value=""> Escolha um Tipo</option>
                        {tipos.map((tipo) => (
                            <option key={tipo.idTipo} value={tipo.nomeTipo}>{tipo.nomeTipo}</option>
                        ))};
                    </select>
                </div>
                <div className="col-2 d-inline-flex p-2 bg-gray justify-content-end">
                    <button type="submit" className="btn btn-primary mx-2 d-inline-flex" onClick={(e) => searchTipo(e)}>
                        <span className="material-icons">
                            search
                        </span>
                    </button>
                </div>
                <div className="col-12 d-inline-flex p-2 justify-content-end">
                    <button type="submit" className="btn btn-primary mx-2 d-inline-flex">
                        <span className="material-icons">
                            delete_forever
                        </span>
                        <p className="m-0">Limpar</p>
                    </button>
                </div>
            </form>
            <div className="container-fluid row my-3 p-2 bg-light">
                <h4 className="text-center bg-primary text-light p-2 m-0">Arquivos</h4>
                <table className="table table-responsive table-hover table-striped ">
                    <thead>
                        <tr className="bg-secondary text-light">
                            <th>Banco</th>
                            <th>Tipo</th>
                            <th>Nome</th>
                            <th>Dt. Geração</th>
                            <th>Gerado por</th>
                            <th>Dt. Envio</th>
                            <th>Qtd linhas</th>
                            <th>Vlr. Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        {arquivos.map((aqv) => (
                            <tr key={aqv.id}>
                                <td>{aqv.banco}</td>
                                <td>{aqv.tipo.nomeTipo}</td>
                                <td>{aqv.nome}</td>
                                <td>{(new Date(aqv.dtGeracao)).toLocaleDateString('en-GB')}</td>
                                <td>{aqv.geradoPor}</td>
                                <td>{(new Date(aqv.dtEnvio)).toLocaleDateString('en-GB')}</td>
                                <td>{aqv.qtdLinhas}</td>
                                <td> R${aqv.vlrTotal}</td>
                            </tr>
                        ))}

                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default HomePage;