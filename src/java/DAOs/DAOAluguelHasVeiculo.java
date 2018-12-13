package DAOs;


import Entidades.AluguelHasVeiculo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOAluguelHasVeiculo extends DAOGenerico<AluguelHasVeiculo> {

    public DAOAluguelHasVeiculo() {
        super(AluguelHasVeiculo.class);
    }

    public int autoIdAluguelHasVeiculo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAluguelHasVeiculo) FROM AluguelHasVeiculo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<AluguelHasVeiculo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM AluguelHasVeiculo e WHERE e.Data LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<AluguelHasVeiculo> listById(int id) {
        return em.createQuery("SELECT e FROM AluguelHasVeiculo e WHERE e.idAluguelHasVeiculo = :id").setParameter("id", id).getResultList();
    }

    public List<AluguelHasVeiculo> listInOrderNome() {
        return em.createQuery("SELECT e FROM AluguelHasVeiculo e ORDER BY e.Data").getResultList();
    }

    public List<AluguelHasVeiculo> listInOrderId() {
        return em.createQuery("SELECT e FROM AluguelHasVeiculo e ORDER BY e.idAluguelHasVeiculo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<AluguelHasVeiculo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdAluguelHasVeiculo() + "-" + lf.get(i).getData());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOAluguelHasVeiculo daoAluguelHasVeiculo = new DAOAluguelHasVeiculo();
        List<AluguelHasVeiculo> listaAluguelHasVeiculo = daoAluguelHasVeiculo.list();
        for (AluguelHasVeiculo veiculo : listaAluguelHasVeiculo) {
            System.out.println(veiculo.getIdAluguelHasVeiculo() + "-" + veiculo.getData());
        }
    }}
