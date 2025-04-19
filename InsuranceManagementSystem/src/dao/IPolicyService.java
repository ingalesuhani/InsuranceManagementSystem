package dao;
import entity.Policy;
import java.util.List;

public interface IPolicyService {
    boolean createNewPolicy(Policy policy); // renamed
    Policy findPolicyById(int policyId);    // renamed
    List<Policy> fetchAllInsurancePlans();  // renamed
    boolean updateExistingPolicy(Policy policy); // renamed
    boolean removePolicy(int policyId);     // renamed
}
