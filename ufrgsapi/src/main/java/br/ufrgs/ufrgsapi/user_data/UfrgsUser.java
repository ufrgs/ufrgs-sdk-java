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
package br.ufrgs.ufrgsapi.user_data;

import br.ufrgs.ufrgsapi.network.pojo.UserData;

/**
 * The entity representing a user.
 *
 * @author Alan Wink
 * @version 1.0
 */

public class UfrgsUser {
    public final String codPessoa;
    public final String nomePessoa;
    public final String cpf;
    public final String dataNascimento;
    public final String estadoCivil;
    public final String sexo;
    public final String escolaridade;
    public final String nomeMae;
    public final String nomePai;
    public final String registroGeral;
    public final String siglaOrgaoEmissorRg;
    public final String dataEmissaoRg;
    public final String ufOrgaoEmissorRg;
    public final String tituloEleitor;
    public final String registroProfissional;
    public final String certificadoReservista;
    public final String nacionalidade;
    public final String codPaisOrigem;
    public final String ufNaturalidade;
    public final String grupoSanguineo;
    public final String prontuarioJuntaMedica;
    public final String prontuarioHcpa;
    public final String doadorOrgaos;
    public final String matriculaAlunoInstituicao;
    public final String instituicaoEnsino;
    public final String logradouro;
    public final String numeroLogradouro;
    public final String complementoLogradouro;
    public final String cep;
    public final String bairro;
    public final String cidade;
    public final String uf;
    public final String codPais;
    public final String passaporte;
    public final String vistoPermanencia;
    public final String telefone;
    public final String ramal;
    public final String fax;
    public final String email;
    public final String foto;
    public final String indicadorForaUFRGS;
    public final String codBanco;
    public final String codAgencia;
    public final String contaCorrente;
    public final String dataObito;
    public final String cartorioObito;
    public final String livroFolhaObito;
    public final String registroObito;
    public final String anoChegadaEstrangeiro;
    public final String cidadeNaturalidade;
    public final String usuarioUltimaAtualizacao;
    public final String dataUltimaAtualizacao;
    public final String nomeConsulta;
    public final String viaCartaoUFRGS;
    public final String dataEmissaoCartaoUFRGS;
    public final String ufTituloEleitor;
    public final String zonaTituloEleitor;
    public final String secaoTituloEleitor;
    public final String dataEmissaoTituloEleitor;
    public final String protocoloEstrangeiro;
    public final String codTipoVisto;
    public final String incisoVisto;
    public final String dataValidadeVistoEstrangeiro;
    public final String dataEntradaEstrangeiro;
    public final String dataProrrogVistoEstrangeiro;
    public final String serieCertificadoReservista;
    public final String emissorCertificadoReservista;
    public final String corPele;
    public final String codReligiao;
    public final String codMunicipioNaturalidade;
    public final String urlPaginaPessoal;
    public final String codPessoaAlfa;
    public final String cpfAlfa;

    public UfrgsUser(UserData data) {
        this.codPessoa = data.getCodPessoa();
        this.nomePessoa = data.getNomePessoa();
        this.cpf = data.getCPF();
        this.dataNascimento = data.getDataNascimento();
        this.estadoCivil = data.getEstadoCivil();
        this.sexo = data.getSexo();
        this.escolaridade = data.getEscolaridade();
        this.nomeMae = data.getNomeMae();
        this.nomePai = data.getNomePai();
        this.registroGeral = data.getNrRegistroGeral();
        this.siglaOrgaoEmissorRg = data.getSiglaOrgaoEmissorRG();
        this.dataEmissaoRg = data.getDataEmissaoRG();
        this.ufOrgaoEmissorRg = data.getUFOrgaoEmissorRG();
        this.tituloEleitor = data.getNrTituloEleitor();
        this.registroProfissional = data.getRegistroProfissional();
        this.certificadoReservista = data.getCertificadoReservista();
        this.nacionalidade = data.getNacionalidade();
        this.codPaisOrigem = data.getCodPaisOrigem();
        this.ufNaturalidade = data.getUFNaturalidade();
        this.grupoSanguineo = data.getGrupoSanguineo();
        this.prontuarioJuntaMedica = data.getNrProntuarioJuntaMedica();
        this.prontuarioHcpa = data.getNrProntuarioHCPA();
        this.doadorOrgaos = data.getDoadorOrgaos();
        this.matriculaAlunoInstituicao = data.getMatriculaAlunoInstituicao();
        this.instituicaoEnsino = data.getInstituicaoEnsino();
        this.logradouro = data.getLogradouro();
        this.numeroLogradouro = data.getNrLogradouro();
        this.complementoLogradouro = data.getComplementoLogradouro();
        this.cep = data.getCEP();
        this.bairro = data.getBairro();
        this.cidade = data.getCidade();
        this.uf = data.getUF();
        this.codPais = data.getCodPais();
        this.passaporte = data.getPassaporte();
        this.vistoPermanencia = data.getNrVistoPermanencia();
        this.telefone = data.getTelefone();
        this.ramal = data.getRamal();
        this.fax = data.getFax();
        this.email = data.getEMail();
        this.foto = data.getFoto();
        this.indicadorForaUFRGS = data.getIndicadorForaUFRGS();
        this.codBanco = data.getCodBanco();
        this.codAgencia = data.getCodAgencia();
        this.contaCorrente = data.getNrContaCorrente();
        this.dataObito = data.getDataObito();
        this.cartorioObito = data.getCartorioObito();
        this.livroFolhaObito = data.getLivroFolhaObito();
        this.registroObito = data.getRegistroObito();
        this.anoChegadaEstrangeiro = data.getAnoChegadaEstrangeiro();
        this.cidadeNaturalidade = data.getCidadeNaturalidade();
        this.usuarioUltimaAtualizacao = data.getUsuarioUltimaAtu();
        this.dataUltimaAtualizacao = data.getDataUltimaAtu();
        this.nomeConsulta = data.getNomeConsulta();
        this.viaCartaoUFRGS = data.getNrViaCartaoUFRGS();
        this.dataEmissaoCartaoUFRGS = data.getDataEmissaoCartaoUFRGS();
        this.ufTituloEleitor = data.getUFTituloEleitor();
        this.zonaTituloEleitor = data.getZonaTituloEleitor();
        this.secaoTituloEleitor = data.getSecaoTituloEleitor();
        this.dataEmissaoTituloEleitor = data.getDataEmissaoTituloEleitor();
        this.protocoloEstrangeiro = data.getProtocoloEstrangeiro();
        this.codTipoVisto = data.getCodTipoVisto();
        this.incisoVisto = data.getIncisoVisto();
        this.dataValidadeVistoEstrangeiro = data.getDataValidadeVistoEstrangeiro();
        this.dataEntradaEstrangeiro = data.getDataEntradaEstrangeiro();
        this.dataProrrogVistoEstrangeiro = data.getDataProrrogVistoEstrangeiro();
        this.serieCertificadoReservista = data.getCertificadoReservista();
        this.emissorCertificadoReservista = data.getEmissorCertificadoReservista();
        this.corPele = data.getCorPele();
        this.codReligiao = data.getCodReligiao();
        this.codMunicipioNaturalidade = data.getCodMunicipioNaturalidade();
        this.urlPaginaPessoal = data.getURLPaginaPessoal();
        this.codPessoaAlfa = data.getCodPessoaAlfa();
        this.cpfAlfa = data.getCPFAlfa();
    }

    @Override
    public String toString() {
        return "UfrgsUser{" +
                "codPessoa='" + codPessoa + '\'' + '\n' +
                ", nomePessoa='" + nomePessoa + '\'' + '\n' +
                ", cpf='" + cpf + '\'' + '\n' +
                ", dataNascimento='" + dataNascimento + '\'' + '\n' +
                ", estadoCivil='" + estadoCivil + '\'' + '\n' +
                ", sexo='" + sexo + '\'' + '\n' +
                ", escolaridade='" + escolaridade + '\'' + '\n' +
                ", nomeMae='" + nomeMae + '\'' + '\n' +
                ", nomePai='" + nomePai + '\'' + '\n' +
                ", registroGeral='" + registroGeral + '\'' + '\n' +
                ", siglaOrgaoEmissorRg='" + siglaOrgaoEmissorRg + '\'' + '\n' +
                ", dataEmissaoRg='" + dataEmissaoRg + '\'' + '\n' +
                ", ufOrgaoEmissorRg='" + ufOrgaoEmissorRg + '\'' + '\n' +
                ", tituloEleitor='" + tituloEleitor + '\'' + '\n' +
                ", registroProfissional='" + registroProfissional + '\'' + '\n' +
                ", certificadoReservista='" + certificadoReservista + '\'' + '\n' +
                ", nacionalidade='" + nacionalidade + '\'' + '\n' +
                ", codPaisOrigem='" + codPaisOrigem + '\'' + '\n' +
                ", ufNaturalidade='" + ufNaturalidade + '\'' + '\n' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' + '\n' +
                ", prontuarioJuntaMedica='" + prontuarioJuntaMedica + '\'' + '\n' +
                ", prontuarioHcpa='" + prontuarioHcpa + '\'' + '\n' +
                ", doadorOrgaos='" + doadorOrgaos + '\'' + '\n' +
                ", matriculaAlunoInstituicao='" + matriculaAlunoInstituicao + '\'' + '\n' +
                ", instituicaoEnsino='" + instituicaoEnsino + '\'' + '\n' +
                ", logradouro='" + logradouro + '\'' + '\n' +
                ", numeroLogradouro='" + numeroLogradouro + '\'' + '\n' +
                ", complementoLogradouro='" + complementoLogradouro + '\'' + '\n' +
                ", cep='" + cep + '\'' + '\n' +
                ", bairro='" + bairro + '\'' + '\n' +
                ", cidade='" + cidade + '\'' + '\n' +
                ", uf='" + uf + '\'' + '\n' +
                ", codPais='" + codPais + '\'' + '\n' +
                ", passaporte='" + passaporte + '\'' + '\n' +
                ", vistoPermanencia='" + vistoPermanencia + '\'' + '\n' +
                ", telefone='" + telefone + '\'' + '\n' +
                ", ramal='" + ramal + '\'' + '\n' +
                ", fax='" + fax + '\'' + '\n' +
                ", email='" + email + '\'' + '\n' +
                ", foto='" + foto + '\'' + '\n' +
                ", indicadorForaUFRGS='" + indicadorForaUFRGS + '\'' + '\n' +
                ", codBanco='" + codBanco + '\'' + '\n' +
                ", codAgencia='" + codAgencia + '\'' + '\n' +
                ", contaCorrente='" + contaCorrente + '\'' + '\n' +
                ", dataObito='" + dataObito + '\'' + '\n' +
                ", cartorioObito='" + cartorioObito + '\'' + '\n' +
                ", livroFolhaObito='" + livroFolhaObito + '\'' + '\n' +
                ", registroObito='" + registroObito + '\'' + '\n' +
                ", anoChegadaEstrangeiro='" + anoChegadaEstrangeiro + '\'' + '\n' +
                ", cidadeNaturalidade='" + cidadeNaturalidade + '\'' + '\n' +
                ", usuarioUltimaAtualizacao='" + usuarioUltimaAtualizacao + '\'' + '\n' +
                ", dataUltimaAtualizacao='" + dataUltimaAtualizacao + '\'' + '\n' +
                ", nomeConsulta='" + nomeConsulta + '\'' + '\n' +
                ", viaCartaoUFRGS='" + viaCartaoUFRGS + '\'' + '\n' +
                ", dataEmissaoCartaoUFRGS='" + dataEmissaoCartaoUFRGS + '\'' + '\n' +
                ", ufTituloEleitor='" + ufTituloEleitor + '\'' + '\n' +
                ", zonaTituloEleitor='" + zonaTituloEleitor + '\'' + '\n' +
                ", secaoTituloEleitor='" + secaoTituloEleitor + '\'' + '\n' +
                ", dataEmissaoTituloEleitor='" + dataEmissaoTituloEleitor + '\'' + '\n' +
                ", protocoloEstrangeiro='" + protocoloEstrangeiro + '\'' + '\n' +
                ", codTipoVisto='" + codTipoVisto + '\'' + '\n' +
                ", incisoVisto='" + incisoVisto + '\'' + '\n' +
                ", dataValidadeVistoEstrangeiro='" + dataValidadeVistoEstrangeiro + '\'' + '\n' +
                ", dataEntradaEstrangeiro='" + dataEntradaEstrangeiro + '\'' + '\n' +
                ", dataProrrogVistoEstrangeiro='" + dataProrrogVistoEstrangeiro + '\'' + '\n' +
                ", serieCertificadoReservista='" + serieCertificadoReservista + '\'' + '\n' +
                ", emissorCertificadoReservista='" + emissorCertificadoReservista + '\'' + '\n' +
                ", corPele='" + corPele + '\'' + '\n' +
                ", codReligiao='" + codReligiao + '\'' + '\n' +
                ", codMunicipioNaturalidade='" + codMunicipioNaturalidade + '\'' + '\n' +
                ", urlPaginaPessoal='" + urlPaginaPessoal + '\'' + '\n' +
                ", codPessoaAlfa='" + codPessoaAlfa + '\'' + '\n' +
                ", cpfAlfa='" + cpfAlfa + '\'' + '\n' +
                '}';
    }
}