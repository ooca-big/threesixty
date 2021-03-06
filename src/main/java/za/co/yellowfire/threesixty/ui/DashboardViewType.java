package za.co.yellowfire.threesixty.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import za.co.yellowfire.threesixty.domain.user.Role;
import za.co.yellowfire.threesixty.domain.user.User;
import za.co.yellowfire.threesixty.ui.view.dashboard.DashboardView;
//import za.co.yellowfire.threesixty.ui.view.kudos.BadgeSearchView;
//import za.co.yellowfire.threesixty.ui.view.kudos.IdealSearchView;
//import za.co.yellowfire.threesixty.ui.view.kudos.KudosEditView;
//import za.co.yellowfire.threesixty.ui.view.org.IdentityView;
//import za.co.yellowfire.threesixty.ui.view.rating.AssessmentSearchView;
//import za.co.yellowfire.threesixty.ui.view.discipline.DisciplineSearchView;
//import za.co.yellowfire.threesixty.ui.view.rating.PeriodSearchView;
//import za.co.yellowfire.threesixty.ui.view.user.UserSearchView;
//import za.co.yellowfire.threesixty.ui.view.user.notification.UserNotificationSearchView;

public enum DashboardViewType {
    DASHBOARD("dashboard", DashboardView.class, VaadinIcons.HOME, true, null),
//    ORGANIZATION(IdentityView.VIEW_NAME, IdentityView.class, I8n.Identity.ICON, true, null),
//    USER_SEARCH(UserSearchView.VIEW_NAME, UserSearchView.class, FontAwesome.USERS, true, Role.ADMIN),
//    PERIOD_SEARCH(PeriodSearchView.VIEW_NAME, PeriodSearchView.class, FontAwesome.CALENDAR_TIMES_O, true, Role.ADMIN),
//    PERFORMANCE_AREA_SEARCH(DisciplineSearchView.VIEW_NAME, DisciplineSearchView.class, FontAwesome.BUILDING_O, true, Role.ADMIN),
//    ASSESSMENT_SEARCH(AssessmentSearchView.VIEW_NAME, AssessmentSearchView.class, FontAwesome.BRIEFCASE, true, null),
//    BADGE_SEARCH(BadgeSearchView.VIEW_NAME, BadgeSearchView.class, FontAwesome.STAR_O, true, Role.ADMIN),
//    IDEAL_SEARCH(IdealSearchView.VIEW_NAME, IdealSearchView.class, FontAwesome.DIAMOND, true, Role.ADMIN),
//    NOTIFICATION_SEARCH(UserNotificationSearchView.VIEW_NAME, UserNotificationSearchView.class, FontAwesome.ENVELOPE_O, true, null),
//    KUDOS(KudosEditView.VIEW_NAME, KudosEditView.class, FontAwesome.HEART_O, true, null)
    ;

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final VaadinIcons icon;
    private final boolean stateful;
    private final Role role;
    
    private DashboardViewType(final String viewName,
            final Class<? extends View> viewClass, final VaadinIcons icon,
            final boolean stateful,
            final Role role) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
        this.role = role;
    }

    public boolean isStateful() { return stateful; }
    public String getViewName() { return viewName; }
    public Class<? extends View> getViewClass() { return viewClass; }
    public VaadinIcons getIcon() { return icon; }
    
    public boolean isAccessibleBy(final User user) {
    	if (this.role == null) { return true; }
    	if (user == null || user.getRole() == null) { return false; }
    	
    	return user.getRole().equals(this.role);
    }
    
    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }
}
