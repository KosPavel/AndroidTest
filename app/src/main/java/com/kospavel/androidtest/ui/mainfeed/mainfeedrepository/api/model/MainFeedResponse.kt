package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model

data class MainFeedResponse(
    val `data`: Data,
    val kind: String
)

data class Data(
    val after: String,
    val before: Any,
    val children: List<Children>,
    val dist: Int,
    val modhash: String,
    val accounts_active: Int,
    val accounts_active_is_fuzzed: Boolean,
    val active_user_count: Int,
    val advertiser_category: String,
    val all_original_content: Boolean,
    val allow_discovery: Boolean,
    val allow_galleries: Boolean,
    val allow_images: Boolean,
    val allow_polls: Boolean,
    val allow_predictions: Boolean,
    val allow_videogifs: Boolean,
    val allow_videos: Boolean,
    val banner_background_color: String,
    val banner_background_image: String,
    val banner_img: String,
    val banner_size: List<Int>,
    val can_assign_link_flair: Boolean,
    val can_assign_user_flair: Boolean,
    val collapse_deleted_comments: Boolean,
    val comment_score_hide_mins: Int,
    val community_icon: String,
    val created: Int,
    val created_utc: Int,
    val description: String,
    val description_html: String,
    val disable_contributor_requests: Boolean,
    val display_name: String,
    val display_name_prefixed: String,
    val emojis_custom_size: Any,
    val emojis_enabled: Boolean,
    val free_form_reports: Boolean,
    val has_menu_widget: Boolean,
    val header_img: String,
    val header_size: List<Int>,
    val header_title: String,
    val hide_ads: Boolean,
    val icon_img: String,
    val icon_size: List<Int>,
    val id: String,
    val is_crosspostable_subreddit: Boolean,
    val is_enrolled_in_new_modmail: Any,
    val key_color: String,
    val lang: String,
    val link_flair_enabled: Boolean,
    val link_flair_position: String,
    val mobile_banner_image: String,
    val name: String,
    val notification_level: Any,
    val original_content_tag_enabled: Boolean,
    val over18: Boolean,
    val primary_color: String,
    val public_description: String,
    val public_description_html: String,
    val public_traffic: Boolean,
    val quarantine: Boolean,
    val restrict_commenting: Boolean,
    val restrict_posting: Boolean,
    val show_media: Boolean,
    val show_media_preview: Boolean,
    val spoilers_enabled: Boolean,
    val submission_type: String,
    val submit_link_label: String,
    val submit_text: String,
    val submit_text_html: String,
    val submit_text_label: String,
    val subreddit_type: String,
    val subscribers: Int,
    val suggested_comment_sort: Any,
    val title: String,
    val url: String,
    val user_can_flair_in_sr: Any,
    val user_flair_background_color: Any,
    val user_flair_css_class: Any,
    val user_flair_enabled_in_sr: Boolean,
    val user_flair_position: String,
    val user_flair_richtext: List<Any>,
    val user_flair_template_id: Any,
    val user_flair_text: Any,
    val user_flair_text_color: Any,
    val user_flair_type: String,
    val user_has_favorited: Any,
    val user_is_banned: Any,
    val user_is_contributor: Any,
    val user_is_moderator: Any,
    val user_is_muted: Any,
    val user_is_subscriber: Any,
    val user_sr_flair_enabled: Any,
    val user_sr_theme_enabled: Boolean,
    val whitelist_status: String,
    val wiki_enabled: Boolean,
    val wls: Int
)

data class Children(
    val `data`: DataX,
    val kind: String
)

data class DataX(
    val all_awardings: List<AllAwarding>,
    val allow_live_comments: Boolean,
    val approved_at_utc: Any,
    val approved_by: Any,
    val archived: Boolean,
    val author: String,
    val author_flair_background_color: Any,
    val author_flair_css_class: Any,
    val author_flair_richtext: List<AuthorFlairRichtext>,
    val author_flair_template_id: Any,
    val author_flair_text: Any,
    val author_flair_text_color: Any,
    val author_flair_type: String,
    val author_fullname: String,
    val author_patreon_flair: Boolean,
    val author_premium: Boolean,
    val awarders: List<Any>,
    val banned_at_utc: Any,
    val banned_by: Any,
    val can_gild: Boolean,
    val can_mod_post: Boolean,
    val category: Any,
    val clicked: Boolean,
    val content_categories: Any,
    val contest_mode: Boolean,
    val created: Double,
    val created_utc: Double,
    val discussion_type: Any,
    val distinguished: Any,
    val domain: String,
    val downs: Int,
    val edited: Any,
    val gilded: Int,
    val gildings: Gildings,
    val hidden: Boolean,
    val hide_score: Boolean,
    val id: String,
    val is_crosspostable: Boolean,
    val is_meta: Boolean,
    val is_original_content: Boolean,
    val is_reddit_media_domain: Boolean,
    val is_robot_indexable: Boolean,
    val is_self: Boolean,
    val is_video: Boolean,
    val likes: Any,
    val link_flair_background_color: String,
    val link_flair_css_class: String,
    val link_flair_richtext: List<LinkFlairRichtext>,
    val link_flair_template_id: String,
    val link_flair_text: String,
    val link_flair_text_color: String,
    val link_flair_type: String,
    val locked: Boolean,
    val media: Any,
    val media_embed: MediaEmbed,
    val media_only: Boolean,
    val mod_note: Any,
    val mod_reason_by: Any,
    val mod_reason_title: Any,
    val mod_reports: List<Any>,
    val name: String,
    val no_follow: Boolean,
    val num_comments: Int,
    val num_crossposts: Int,
    val num_reports: Any,
    val over_18: Boolean,
    val parent_whitelist_status: String,
    val permalink: String,
    val pinned: Boolean,
    val post_hint: String,
    val preview: Preview,
    val pwls: Int,
    val quarantine: Boolean,
    val removal_reason: Any,
    val removed_by: Any,
    val removed_by_category: Any,
    val report_reasons: Any,
    val saved: Boolean,
    val score: Int,
    val secure_media: Any,
    val secure_media_embed: SecureMediaEmbed,
    val selftext: String,
    val selftext_html: Any,
    val send_replies: Boolean,
    val spoiler: Boolean,
    val stickied: Boolean,
    val subreddit: String,
    val subreddit_id: String,
    val subreddit_name_prefixed: String,
    val subreddit_subscribers: Int,
    val subreddit_type: String,
    val suggested_sort: Any,
    val thumbnail: String,
    val thumbnail_height: Int,
    val thumbnail_width: Int,
    val title: String,
    val top_awarded_type: Any,
    val total_awards_received: Int,
    val treatment_tags: List<Any>,
    val ups: Int,
    val upvote_ratio: Double,
    val url: String,
    val url_overridden_by_dest: String,
    val user_reports: List<Any>,
    val view_count: Any,
    val visited: Boolean,
    val whitelist_status: String,
    val wls: Int
)

data class AllAwarding(
    val award_sub_type: String,
    val award_type: String,
    val awardings_required_to_grant_benefits: Any,
    val coin_price: Int,
    val coin_reward: Int,
    val count: Int,
    val days_of_drip_extension: Int,
    val days_of_premium: Int,
    val description: String,
    val end_date: Any,
    val giver_coin_reward: Any,
    val icon_format: Any,
    val icon_height: Int,
    val icon_url: String,
    val icon_width: Int,
    val id: String,
    val is_enabled: Boolean,
    val is_new: Boolean,
    val name: String,
    val penny_donate: Any,
    val penny_price: Any,
    val resized_icons: List<ResizedIcon>,
    val resized_static_icons: List<ResizedStaticIcon>,
    val start_date: Any,
    val static_icon_height: Int,
    val static_icon_url: String,
    val static_icon_width: Int,
    val subreddit_coin_reward: Int,
    val subreddit_id: Any,
    val tiers_by_required_awardings: Any
)

data class AuthorFlairRichtext(
    val a: String,
    val e: String,
    val t: String,
    val u: String
)

data class Gif(
    val resolutions: List<ResolutionX>,
    val source: SourceX
)

data class Gildings(
    val gid_1: Int,
    val gid_2: Int,
    val gid_3: Int
)

data class Image(
    val id: String,
    val resolutions: List<Resolution>,
    val source: Source,
    val variants: Variants
)

data class LinkFlairRichtext(
    val e: String,
    val t: String
)

data class MediaEmbed(
    val content: String,
    val height: Int,
    val scrolling: Boolean,
    val width: Int
)

data class Mp4(
    val resolutions: List<ResolutionXX>,
    val source: SourceXX
)

data class Preview(
    val enabled: Boolean,
    val images: List<Image>,
    val reddit_video_preview: RedditVideoPreview
)

data class RedditVideoPreview(
    val dash_url: String,
    val duration: Int,
    val fallback_url: String,
    val height: Int,
    val hls_url: String,
    val is_gif: Boolean,
    val scrubber_media_url: String,
    val transcoding_status: String,
    val width: Int
)

data class ResizedIcon(
    val height: Int,
    val url: String,
    val width: Int
)

data class ResizedStaticIcon(
    val height: Int,
    val url: String,
    val width: Int
)

data class Resolution(
    val height: Int,
    val url: String,
    val width: Int
)

data class ResolutionX(
    val height: Int,
    val url: String,
    val width: Int
)

data class ResolutionXX(
    val height: Int,
    val url: String,
    val width: Int
)

data class SecureMediaEmbed(
    val content: String,
    val height: Int,
    val media_domain_url: String,
    val scrolling: Boolean,
    val width: Int
)

data class Source(
    val height: Int,
    val url: String,
    val width: Int
)

data class SourceX(
    val height: Int,
    val url: String,
    val width: Int
)

data class SourceXX(
    val height: Int,
    val url: String,
    val width: Int
)

data class Variants(
    val gif: Gif,
    val mp4: Mp4
)