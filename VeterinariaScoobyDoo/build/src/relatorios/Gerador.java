package relatorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Gerador {

    public static void geraRelatorioConsultas() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n" + "     animal.\"nome\" AS animal_nome,\n"
                    + "     consulta.\"status\" AS consulta_status,\n"
                    + "     dono.\"nome\" AS dono_nome,\n"
                    + "     veterinario.\"nome\" AS veterinario_nome,\n"
                    + "     animal.\"especie\" AS animal_especie,\n"
                    + "     consulta.\"valor\" AS consulta_valor,\n"
                    + "     consulta.\"data\" AS consulta_data\n"
                    + "FROM\n"
                    + "     \"public\".\"animal\" animal INNER JOIN \"public\".\"consulta\" consulta ON animal.\"codanimal\" = consulta.\"codanimal\"\n"
                    + "     INNER JOIN \"public\".\"dono\" dono ON animal.\"coddono\" = dono.\"coddono\"\n"
                    + "     INNER JOIN \"public\".\"veterinario\" veterinario ON consulta.\"codveterinario\" = veterinario.\"codveterinario\"";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/relatorio1.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRelatorioAnimais() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n"
                    + "     animal.\"codanimal\" AS animal_codanimal,\n"
                    + "     animal.\"idade\" AS animal_idade,\n"
                    + "     animal.\"nome\" AS animal_nome,\n"
                    + "     animal.\"raça\" AS animal_raça,\n"
                    + "     animal.\"especie\" AS animal_especie,\n"
                    + "     dono.\"nome\" AS dono_nome\n"
                    + "FROM\n"
                    + "     \"public\".\"dono\" dono INNER JOIN \"public\".\"animal\" animal ON dono.\"coddono\" = animal.\"coddono\"";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/reportAnimais.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRelatorioProduto() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n"
                    + "     produto.\"descricao\" AS produto_descricao,\n"
                    + "     produto.\"nome\" AS produto_nome,\n"
                    + "     produto.\"valor\" AS produto_valor,\n"
                    + "     produto.\"codproduto\" AS produto_codproduto\n"
                    + "FROM\n"
                    + "     \"public\".\"produto\" produto";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/reportProdutos.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRelatorioClientes() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n"
                    + "     dono.\"coddono\" AS dono_coddono,\n"
                    + "     dono.\"endereco\" AS dono_endereco,\n"
                    + "     dono.\"nome\" AS dono_nome,\n"
                    + "     animal.\"nome\" AS animal_nome,\n"
                    + "     dono.\"cpf\" AS dono_cpf,\n"
                    + "     animal.\"especie\" AS animal_especie\n"
                    + "FROM\n"
                    + "     \"public\".\"dono\" dono INNER JOIN \"public\".\"animal\" animal ON dono.\"coddono\" = animal.\"coddono\"";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/reportClientes.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRelatorioFuncionarios() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n"
                    + "     usuario.\"codusuario\" AS usuario_codusuario,\n"
                    + "     usuario.\"cargo\" AS usuario_cargo,\n"
                    + "     usuario.\"nome\" AS usuario_nome,\n"
                    + "     usuario.\"endereco\" AS usuario_endereco,\n"
                    + "     usuario.\"cpf\" AS usuario_cpf\n"
                    + "FROM\n"
                    + "     \"public\".\"usuario\" usuario";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/reportFuncionarios.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRelatorioConsulta() {
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            Connection connection = new Conexao().getConnection();
            String sql = "SELECT\n"
                    + "     consulta.\"data\" AS consulta_data,\n"
                    + "     consulta.\"status\" AS consulta_status,\n"
                    + "     consulta.\"valor\" AS consulta_valor,\n"
                    + "     dono.\"nome\" AS dono_nome,\n"
                    + "     animal.\"nome\" AS animal_nome,\n"
                    + "     animal.\"especie\" AS animal_especie,\n"
                    + "     veterinario.\"nome\" AS veterinario_nome,\n"
                    + "     veterinario.\"cargo\" AS veterinario_cargo,\n"
                    + "     consulta.\"codconsulta\" AS consulta_codconsulta\n"
                    + "FROM\n"
                    + "     \"public\".\"dono\" dono INNER JOIN \"public\".\"consulta\" consulta ON dono.\"coddono\" = consulta.\"coddono\"\n"
                    + "     INNER JOIN \"public\".\"animal\" animal ON dono.\"coddono\" = animal.\"coddono\"\n"
                    + "     AND animal.\"codanimal\" = consulta.\"codanimal\"\n"
                    + "     INNER JOIN \"public\".\"veterinario\" veterinario ON consulta.\"codveterinario\" = veterinario.\"codveterinario\"";

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JasperCompileManager.compileReportToFile("src/relatorios/reportConsultas.jrxml", "src/relatorios/relatorio1.jasper");
            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("src/relatorios/relatorio1.jasper", parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
