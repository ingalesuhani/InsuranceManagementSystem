package dao;
import entity.Policy;
import exception.PolicyNotFoundException;
import util.DBConnUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceServiceImpl implements IPolicyService {
    private Connection conn = DBConnUtil.getConnection();

    public boolean createNewPolicy(Policy policy) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Policy VALUES (?, ?, ?)");
            ps.setInt(1, policy.getPolicyId());
            ps.setString(2, policy.getPolicyName());
            ps.setDouble(3, policy.getCoverageAmount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Something went wrong while inserting the policy.");
        }
        return false;
    }

    public Policy findPolicyById(int policyId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Policy WHERE policyId = ?");
            ps.setInt(1, policyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Policy(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            } else {
                throw new PolicyNotFoundException("No policy found for id: " + policyId);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching policy by id.");
        }
        return null;
    }

    public List<Policy> fetchAllInsurancePlans() {
        List<Policy> policyList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Policy");

            // iterating through results
            while (rs.next()) {
                Policy p = new Policy(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                policyList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't fetch all policies. Check DB connection?");
        }
        return policyList;
    }

    public boolean updateExistingPolicy(Policy policy) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Policy SET policyName = ?, coverageAmount = ? WHERE policyId = ?");
            ps.setString(1, policy.getPolicyName());
            ps.setDouble(2, policy.getCoverageAmount());
            ps.setInt(3, policy.getPolicyId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update policy. Try again.");
        }
        return false;
    }

    public boolean removePolicy(int policyId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Policy WHERE policyId = ?");
            ps.setInt(1, policyId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Couldn't delete the policy.");
        }
        return false;
    }
}
