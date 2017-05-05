/*
 * Copyright 2016 Universidade Federal do Rio Grande do Sul
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.ufrgs.ufrgsapi.network.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Alan Wink
 * @version 1.0
 */

public class UserData {

    @SerializedName("CodPessoa")
    @Expose
    private String CodPessoa;
    @SerializedName("NomePessoa")
    @Expose
    private String NomePessoa;
    @SerializedName("CPF")
    @Expose
    private String CPF;
    @SerializedName("DataNascimento")
    @Expose
    private String DataNascimento;
    @SerializedName("EstadoCivil")
    @Expose
    private String EstadoCivil;
    @SerializedName("Sexo")
    @Expose
    private String Sexo;
    @SerializedName("Escolaridade")
    @Expose
    private String Escolaridade;
    @SerializedName("NomeMae")
    @Expose
    private String NomeMae;
    @SerializedName("NomePai")
    @Expose
    private String NomePai;
    @SerializedName("NrRegistroGeral")
    @Expose
    private String NrRegistroGeral;
    @SerializedName("SiglaOrgaoEmissorRG")
    @Expose
    private String SiglaOrgaoEmissorRG;
    @SerializedName("DataEmissaoRG")
    @Expose
    private String DataEmissaoRG;
    @SerializedName("UFOrgaoEmissorRG")
    @Expose
    private String UFOrgaoEmissorRG;
    @SerializedName("NrTituloEleitor")
    @Expose
    private String NrTituloEleitor;
    @SerializedName("RegistroProfissional")
    @Expose
    private String RegistroProfissional;
    @SerializedName("CertificadoReservista")
    @Expose
    private String CertificadoReservista;
    @SerializedName("Nacionalidade")
    @Expose
    private String Nacionalidade;
    @SerializedName("CodPaisOrigem")
    @Expose
    private String CodPaisOrigem;
    @SerializedName("UFNaturalidade")
    @Expose
    private String UFNaturalidade;
    @SerializedName("GrupoSanguineo")
    @Expose
    private String GrupoSanguineo;
    @SerializedName("NrProntuarioJuntaMedica")
    @Expose
    private String NrProntuarioJuntaMedica;
    @SerializedName("NrProntuarioHCPA")
    @Expose
    private String NrProntuarioHCPA;
    @SerializedName("DoadorOrgaos")
    @Expose
    private String DoadorOrgaos;
    @SerializedName("MatriculaAlunoInstituicao")
    @Expose
    private String MatriculaAlunoInstituicao;
    @SerializedName("InstituicaoEnsino")
    @Expose
    private String InstituicaoEnsino;
    @SerializedName("Logradouro")
    @Expose
    private String Logradouro;
    @SerializedName("NrLogradouro")
    @Expose
    private String NrLogradouro;
    @SerializedName("ComplementoLogradouro")
    @Expose
    private String ComplementoLogradouro;
    @SerializedName("CEP")
    @Expose
    private String CEP;
    @SerializedName("Bairro")
    @Expose
    private String Bairro;
    @SerializedName("Cidade")
    @Expose
    private String Cidade;
    @SerializedName("UF")
    @Expose
    private String UF;
    @SerializedName("CodPais")
    @Expose
    private String CodPais;
    @SerializedName("Passaporte")
    @Expose
    private String Passaporte;
    @SerializedName("NrVistoPermanencia")
    @Expose
    private String NrVistoPermanencia;
    @SerializedName("Telefone")
    @Expose
    private String Telefone;
    @SerializedName("Ramal")
    @Expose
    private String Ramal;
    @SerializedName("Fax")
    @Expose
    private String Fax;
    @SerializedName("EMail")
    @Expose
    private String EMail;
    @SerializedName("Foto")
    @Expose
    private String Foto;
    @SerializedName("IndicadorForaUFRGS")
    @Expose
    private String IndicadorForaUFRGS;
    @SerializedName("CodBanco")
    @Expose
    private String CodBanco;
    @SerializedName("CodAgencia")
    @Expose
    private String CodAgencia;
    @SerializedName("NrContaCorrente")
    @Expose
    private String NrContaCorrente;
    @SerializedName("DataObito")
    @Expose
    private String DataObito;
    @SerializedName("CartorioObito")
    @Expose
    private String CartorioObito;
    @SerializedName("LivroFolhaObito")
    @Expose
    private String LivroFolhaObito;
    @SerializedName("RegistroObito")
    @Expose
    private String RegistroObito;
    @SerializedName("AnoChegadaEstrangeiro")
    @Expose
    private String AnoChegadaEstrangeiro;
    @SerializedName("CidadeNaturalidade")
    @Expose
    private String CidadeNaturalidade;
    @SerializedName("UsuarioUltimaAtu")
    @Expose
    private String UsuarioUltimaAtu;
    @SerializedName("DataUltimaAtu")
    @Expose
    private String DataUltimaAtu;
    @SerializedName("NomeConsulta")
    @Expose
    private String NomeConsulta;
    @SerializedName("NrViaCartaoUFRGS")
    @Expose
    private String NrViaCartaoUFRGS;
    @SerializedName("DataEmissaoCartaoUFRGS")
    @Expose
    private String DataEmissaoCartaoUFRGS;
    @SerializedName("UFTituloEleitor")
    @Expose
    private String UFTituloEleitor;
    @SerializedName("ZonaTituloEleitor")
    @Expose
    private String ZonaTituloEleitor;
    @SerializedName("SecaoTituloEleitor")
    @Expose
    private String SecaoTituloEleitor;
    @SerializedName("DataEmissaoTituloEleitor")
    @Expose
    private String DataEmissaoTituloEleitor;
    @SerializedName("ProtocoloEstrangeiro")
    @Expose
    private String ProtocoloEstrangeiro;
    @SerializedName("CodTipoVisto")
    @Expose
    private String CodTipoVisto;
    @SerializedName("IncisoVisto")
    @Expose
    private String IncisoVisto;
    @SerializedName("DataValidadeVistoEstrangeiro")
    @Expose
    private String DataValidadeVistoEstrangeiro;
    @SerializedName("DataEntradaEstrangeiro")
    @Expose
    private String DataEntradaEstrangeiro;
    @SerializedName("DataProrrogVistoEstrangeiro")
    @Expose
    private String DataProrrogVistoEstrangeiro;
    @SerializedName("SerieCertificadoReservista")
    @Expose
    private String SerieCertificadoReservista;
    @SerializedName("EmissorCertificadoReservista")
    @Expose
    private String EmissorCertificadoReservista;
    @SerializedName("CorPele")
    @Expose
    private String CorPele;
    @SerializedName("CodReligiao")
    @Expose
    private String CodReligiao;
    @SerializedName("CodMunicipioNaturalidade")
    @Expose
    private String CodMunicipioNaturalidade;
    @SerializedName("URLPaginaPessoal")
    @Expose
    private String URLPaginaPessoal;
    @SerializedName("CodPessoaAlfa")
    @Expose
    private String CodPessoaAlfa;
    @SerializedName("CPFAlfa")
    @Expose
    private String CPFAlfa;

    public String getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(String codPessoa) {
        CodPessoa = codPessoa;
    }

    public String getNomePessoa() {
        return NomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        NomePessoa = nomePessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getEscolaridade() {
        return Escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        Escolaridade = escolaridade;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String nomeMae) {
        NomeMae = nomeMae;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String nomePai) {
        NomePai = nomePai;
    }

    public String getNrRegistroGeral() {
        return NrRegistroGeral;
    }

    public void setNrRegistroGeral(String nrRegistroGeral) {
        NrRegistroGeral = nrRegistroGeral;
    }

    public String getSiglaOrgaoEmissorRG() {
        return SiglaOrgaoEmissorRG;
    }

    public void setSiglaOrgaoEmissorRG(String siglaOrgaoEmissorRG) {
        SiglaOrgaoEmissorRG = siglaOrgaoEmissorRG;
    }

    public String getDataEmissaoRG() {
        return DataEmissaoRG;
    }

    public void setDataEmissaoRG(String dataEmissaoRG) {
        DataEmissaoRG = dataEmissaoRG;
    }

    public String getUFOrgaoEmissorRG() {
        return UFOrgaoEmissorRG;
    }

    public void setUFOrgaoEmissorRG(String UFOrgaoEmissorRG) {
        this.UFOrgaoEmissorRG = UFOrgaoEmissorRG;
    }

    public String getNrTituloEleitor() {
        return NrTituloEleitor;
    }

    public void setNrTituloEleitor(String nrTituloEleitor) {
        NrTituloEleitor = nrTituloEleitor;
    }

    public String getRegistroProfissional() {
        return RegistroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        RegistroProfissional = registroProfissional;
    }

    public String getCertificadoReservista() {
        return CertificadoReservista;
    }

    public void setCertificadoReservista(String certificadoReservista) {
        CertificadoReservista = certificadoReservista;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        Nacionalidade = nacionalidade;
    }

    public String getCodPaisOrigem() {
        return CodPaisOrigem;
    }

    public void setCodPaisOrigem(String codPaisOrigem) {
        CodPaisOrigem = codPaisOrigem;
    }

    public String getUFNaturalidade() {
        return UFNaturalidade;
    }

    public void setUFNaturalidade(String UFNaturalidade) {
        this.UFNaturalidade = UFNaturalidade;
    }

    public String getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        GrupoSanguineo = grupoSanguineo;
    }

    public String getNrProntuarioJuntaMedica() {
        return NrProntuarioJuntaMedica;
    }

    public void setNrProntuarioJuntaMedica(String nrProntuarioJuntaMedica) {
        NrProntuarioJuntaMedica = nrProntuarioJuntaMedica;
    }

    public String getNrProntuarioHCPA() {
        return NrProntuarioHCPA;
    }

    public void setNrProntuarioHCPA(String nrProntuarioHCPA) {
        NrProntuarioHCPA = nrProntuarioHCPA;
    }

    public String getDoadorOrgaos() {
        return DoadorOrgaos;
    }

    public void setDoadorOrgaos(String doadorOrgaos) {
        DoadorOrgaos = doadorOrgaos;
    }

    public String getMatriculaAlunoInstituicao() {
        return MatriculaAlunoInstituicao;
    }

    public void setMatriculaAlunoInstituicao(String matriculaAlunoInstituicao) {
        MatriculaAlunoInstituicao = matriculaAlunoInstituicao;
    }

    public String getInstituicaoEnsino() {
        return InstituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        InstituicaoEnsino = instituicaoEnsino;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getNrLogradouro() {
        return NrLogradouro;
    }

    public void setNrLogradouro(String nrLogradouro) {
        NrLogradouro = nrLogradouro;
    }

    public String getComplementoLogradouro() {
        return ComplementoLogradouro;
    }

    public void setComplementoLogradouro(String complementoLogradouro) {
        ComplementoLogradouro = complementoLogradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCodPais() {
        return CodPais;
    }

    public void setCodPais(String codPais) {
        CodPais = codPais;
    }

    public String getPassaporte() {
        return Passaporte;
    }

    public void setPassaporte(String passaporte) {
        Passaporte = passaporte;
    }

    public String getNrVistoPermanencia() {
        return NrVistoPermanencia;
    }

    public void setNrVistoPermanencia(String nrVistoPermanencia) {
        NrVistoPermanencia = nrVistoPermanencia;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getRamal() {
        return Ramal;
    }

    public void setRamal(String ramal) {
        Ramal = ramal;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getIndicadorForaUFRGS() {
        return IndicadorForaUFRGS;
    }

    public void setIndicadorForaUFRGS(String indicadorForaUFRGS) {
        IndicadorForaUFRGS = indicadorForaUFRGS;
    }

    public String getCodBanco() {
        return CodBanco;
    }

    public void setCodBanco(String codBanco) {
        CodBanco = codBanco;
    }

    public String getCodAgencia() {
        return CodAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        CodAgencia = codAgencia;
    }

    public String getNrContaCorrente() {
        return NrContaCorrente;
    }

    public void setNrContaCorrente(String nrContaCorrente) {
        NrContaCorrente = nrContaCorrente;
    }

    public String getDataObito() {
        return DataObito;
    }

    public void setDataObito(String dataObito) {
        DataObito = dataObito;
    }

    public String getCartorioObito() {
        return CartorioObito;
    }

    public void setCartorioObito(String cartorioObito) {
        CartorioObito = cartorioObito;
    }

    public String getLivroFolhaObito() {
        return LivroFolhaObito;
    }

    public void setLivroFolhaObito(String livroFolhaObito) {
        LivroFolhaObito = livroFolhaObito;
    }

    public String getRegistroObito() {
        return RegistroObito;
    }

    public void setRegistroObito(String registroObito) {
        RegistroObito = registroObito;
    }

    public String getAnoChegadaEstrangeiro() {
        return AnoChegadaEstrangeiro;
    }

    public void setAnoChegadaEstrangeiro(String anoChegadaEstrangeiro) {
        AnoChegadaEstrangeiro = anoChegadaEstrangeiro;
    }

    public String getCidadeNaturalidade() {
        return CidadeNaturalidade;
    }

    public void setCidadeNaturalidade(String cidadeNaturalidade) {
        CidadeNaturalidade = cidadeNaturalidade;
    }

    public String getUsuarioUltimaAtu() {
        return UsuarioUltimaAtu;
    }

    public void setUsuarioUltimaAtu(String usuarioUltimaAtu) {
        UsuarioUltimaAtu = usuarioUltimaAtu;
    }

    public String getDataUltimaAtu() {
        return DataUltimaAtu;
    }

    public void setDataUltimaAtu(String dataUltimaAtu) {
        DataUltimaAtu = dataUltimaAtu;
    }

    public String getNomeConsulta() {
        return NomeConsulta;
    }

    public void setNomeConsulta(String nomeConsulta) {
        NomeConsulta = nomeConsulta;
    }

    public String getNrViaCartaoUFRGS() {
        return NrViaCartaoUFRGS;
    }

    public void setNrViaCartaoUFRGS(String nrViaCartaoUFRGS) {
        NrViaCartaoUFRGS = nrViaCartaoUFRGS;
    }

    public String getDataEmissaoCartaoUFRGS() {
        return DataEmissaoCartaoUFRGS;
    }

    public void setDataEmissaoCartaoUFRGS(String dataEmissaoCartaoUFRGS) {
        DataEmissaoCartaoUFRGS = dataEmissaoCartaoUFRGS;
    }

    public String getUFTituloEleitor() {
        return UFTituloEleitor;
    }

    public void setUFTituloEleitor(String UFTituloEleitor) {
        this.UFTituloEleitor = UFTituloEleitor;
    }

    public String getZonaTituloEleitor() {
        return ZonaTituloEleitor;
    }

    public void setZonaTituloEleitor(String zonaTituloEleitor) {
        ZonaTituloEleitor = zonaTituloEleitor;
    }

    public String getSecaoTituloEleitor() {
        return SecaoTituloEleitor;
    }

    public void setSecaoTituloEleitor(String secaoTituloEleitor) {
        SecaoTituloEleitor = secaoTituloEleitor;
    }

    public String getDataEmissaoTituloEleitor() {
        return DataEmissaoTituloEleitor;
    }

    public void setDataEmissaoTituloEleitor(String dataEmissaoTituloEleitor) {
        DataEmissaoTituloEleitor = dataEmissaoTituloEleitor;
    }

    public String getProtocoloEstrangeiro() {
        return ProtocoloEstrangeiro;
    }

    public void setProtocoloEstrangeiro(String protocoloEstrangeiro) {
        ProtocoloEstrangeiro = protocoloEstrangeiro;
    }

    public String getCodTipoVisto() {
        return CodTipoVisto;
    }

    public void setCodTipoVisto(String codTipoVisto) {
        CodTipoVisto = codTipoVisto;
    }

    public String getIncisoVisto() {
        return IncisoVisto;
    }

    public void setIncisoVisto(String incisoVisto) {
        IncisoVisto = incisoVisto;
    }

    public String getDataValidadeVistoEstrangeiro() {
        return DataValidadeVistoEstrangeiro;
    }

    public void setDataValidadeVistoEstrangeiro(String dataValidadeVistoEstrangeiro) {
        DataValidadeVistoEstrangeiro = dataValidadeVistoEstrangeiro;
    }

    public String getDataEntradaEstrangeiro() {
        return DataEntradaEstrangeiro;
    }

    public void setDataEntradaEstrangeiro(String dataEntradaEstrangeiro) {
        DataEntradaEstrangeiro = dataEntradaEstrangeiro;
    }

    public String getDataProrrogVistoEstrangeiro() {
        return DataProrrogVistoEstrangeiro;
    }

    public void setDataProrrogVistoEstrangeiro(String dataProrrogVistoEstrangeiro) {
        DataProrrogVistoEstrangeiro = dataProrrogVistoEstrangeiro;
    }

    public String getSerieCertificadoReservista() {
        return SerieCertificadoReservista;
    }

    public void setSerieCertificadoReservista(String serieCertificadoReservista) {
        SerieCertificadoReservista = serieCertificadoReservista;
    }

    public String getEmissorCertificadoReservista() {
        return EmissorCertificadoReservista;
    }

    public void setEmissorCertificadoReservista(String emissorCertificadoReservista) {
        EmissorCertificadoReservista = emissorCertificadoReservista;
    }

    public String getCorPele() {
        return CorPele;
    }

    public void setCorPele(String corPele) {
        CorPele = corPele;
    }

    public String getCodReligiao() {
        return CodReligiao;
    }

    public void setCodReligiao(String codReligiao) {
        CodReligiao = codReligiao;
    }

    public String getCodMunicipioNaturalidade() {
        return CodMunicipioNaturalidade;
    }

    public void setCodMunicipioNaturalidade(String codMunicipioNaturalidade) {
        CodMunicipioNaturalidade = codMunicipioNaturalidade;
    }

    public String getURLPaginaPessoal() {
        return URLPaginaPessoal;
    }

    public void setURLPaginaPessoal(String URLPaginaPessoal) {
        this.URLPaginaPessoal = URLPaginaPessoal;
    }

    public String getCodPessoaAlfa() {
        return CodPessoaAlfa;
    }

    public void setCodPessoaAlfa(String codPessoaAlfa) {
        CodPessoaAlfa = codPessoaAlfa;
    }

    public String getCPFAlfa() {
        return CPFAlfa;
    }

    public void setCPFAlfa(String CPFAlfa) {
        this.CPFAlfa = CPFAlfa;
    }
}