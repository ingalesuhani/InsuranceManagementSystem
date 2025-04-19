package dao;
import entity.Policy;
import java.util.List;

public interface IPolicyService {
    boolean createNewPolicy(Policy policy); 
    Policy findPolicyById(int policyId);    
    List<Policy> fetchAllInsurancePlans(); 
    boolean updateExistingPolicy(Policy policy); 
    boolean removePolicy(int policyId);     // renamed
}
