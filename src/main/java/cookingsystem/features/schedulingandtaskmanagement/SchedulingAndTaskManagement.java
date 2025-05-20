package cookingsystem.features.schedulingandtaskmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchedulingAndTaskManagement {

    // خريطة تجمع اسم الشيف مع قائمة المهام المسندة له
    private Map<String, List<String>> chefTasks = new HashMap<>();
    // خريطة للاشعارات لكل شيف
    private Map<String, List<String>> notifications = new HashMap<>();

    // تعيين مهمة لشيف معين
    public void assignTaskToChef(String task, String chefName) {
        chefTasks.putIfAbsent(chefName, new ArrayList<>());
        chefTasks.get(chefName).add(task);

        // إرسال إشعار للشيف
        notifications.putIfAbsent(chefName, new ArrayList<>());
        notifications.get(chefName).add("New task assigned: " + task);
    }

    // استرجاع قائمة المهام لشيف معين
    public List<String> getTasksForChef(String chefName) {
        return chefTasks.getOrDefault(chefName, new ArrayList<>());
    }

    // استرجاع الاشعارات لشيف معين
    public List<String> getNotificationsForChef(String chefName) {
        return notifications.getOrDefault(chefName, new ArrayList<>());
    }

    // عرض عبء العمل (عدد المهام) لكل شيف
    public Map<String, Integer> getWorkloadPerChef() {
        Map<String, Integer> workload = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : chefTasks.entrySet()) {
            workload.put(entry.getKey(), entry.getValue().size());
        }
        return workload;
    }

    // تحديد إذا كان الشيف متعب (مثلاً أكثر من 5 مهام)
    public List<String> getOverworkedChefs(int threshold) {
        List<String> overworked = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : chefTasks.entrySet()) {
            if (entry.getValue().size() > threshold) {
                overworked.add(entry.getKey());
            }
        }
        return overworked;
    }
}
